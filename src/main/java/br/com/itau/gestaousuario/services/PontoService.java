package br.com.itau.gestaousuario.services;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.gestaousuario.models.Listagem;
import br.com.itau.gestaousuario.models.Ponto;
import br.com.itau.gestaousuario.models.Usuario;
import br.com.itau.gestaousuario.repositories.PontoRepository;
import br.com.itau.gestaousuario.repositories.UsuarioRepository;

@Service
public class PontoService 
{
	@Autowired
	PontoRepository pontoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Ponto salvaPonto(int idUsuario, String tipoPonto)
	{
		Usuario usuario = usuarioRepository.findById(idUsuario);
		
		if(usuario == null)
		{
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "Usuário não encontrado - Verifique o parâmetro Id informado");
		}
		
		Ponto ultimoPonto = pontoRepository.findLastPontoByUser(idUsuario);

		Ponto ponto = new Ponto();
		ponto.setUsuario(usuario);
		ponto.setDataPonto(ZonedDateTime.now());
		ponto.setTipoPonto(tipoPonto);
		
		if(ultimoPonto == null)
		{
			if(tipoPonto.contentEquals("entrada"))
			{
				return pontoRepository.save(ponto);
			}
			else
			{
		    	throw new ResponseStatusException(
		    	          HttpStatus.BAD_REQUEST, "Não é possível registrar o ponto de saída, pois não existe nenhum ponto de entrada. Registre o ponto de entrada antes de registrar o ponto de saída.");
			}
		}
		else
		{
			if(ultimoPonto.getTipoPonto().contentEquals(tipoPonto)) {
		    	throw new ResponseStatusException(
		    	          HttpStatus.BAD_REQUEST, "Não é possível registrar duas entradas ou duas saídas, altere o tipo de registro de ponto.");				
			}
			else
			{
				return pontoRepository.save(ponto);
			}
		}
	}
	
	public ResponseEntity<Listagem> consultaPontoUsuario(int  idUsuario)
	{
		List<Ponto> listaPonto = pontoRepository.findAllPontoByUser(idUsuario);
		
		if(listaPonto != null && listaPonto.size() > 0)
		{
			ZonedDateTime dtAux = null;
			long qtdHorasTrabalhadas = 0;
			boolean isFirst = true;
			
			for(Ponto p : listaPonto) 
			{
				// Se o primeiro elemento for um registro de entrada, não contabilizaremos as horas em aberto
				if(isFirst && p.getTipoPonto().contentEquals("entrada")) 
				{
					isFirst = false;
					continue;
				}
				else
				{
					isFirst = false;
					if(p.getTipoPonto().contentEquals("saida")) 
					{
						dtAux = p.getDataPonto();
					}
					else
					{
						qtdHorasTrabalhadas += ChronoUnit.HOURS.between(p.getDataPonto(), dtAux);
					}
				}
			}
			
			Listagem listagem = new Listagem();
			listagem.setListagemPontos(listaPonto);
			listagem.setTotalHorasTrabalhadas(qtdHorasTrabalhadas);
			
			return new ResponseEntity<Listagem>(listagem, HttpStatus.OK);
		}
		else
		{
	    	throw new ResponseStatusException(
	    	          HttpStatus.NOT_FOUND, "Usuário não encontrado ou não possui nenhum registro de ponto");
		}
		
	}
}
