package br.com.itau.gestaousuario.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.gestaousuario.models.Ponto;
import br.com.itau.gestaousuario.models.Usuario;
import br.com.itau.gestaousuario.repositories.PontoRepository;
import br.com.itau.gestaousuario.repositories.UsuarioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

@SpringBootTest
public class PontoServiceTest 
{
	@Autowired
	PontoService pontoService;
	
	@MockBean
	PontoRepository pontoRepository;

	@MockBean
	UsuarioRepository usuarioRepository;
	
	Usuario usuario;
	Ponto ponto;
	
	@BeforeEach
	public void inicializarVariaveis()
	{	
		usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Fellipe Leão Marques Ferraz");
		usuario.setCpf("123.456.789-10");
		usuario.setEmail("teste@teste.com");
		usuario.setDataCadastro(ZonedDateTime.now());
		
		ponto = new Ponto();
		ponto.setId(1);
		ponto.setTipoPonto("entrada");
		ponto.setDataPonto(ZonedDateTime.now());
	}
	
	@Test
	public void testarSalvaPontoEntradaOK()
	{
		int idUsuario = 1;
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(usuario);
		Mockito.when(pontoRepository.findLastPontoByUser(idUsuario)).thenReturn(null);
		Mockito.when(pontoRepository.save(ArgumentMatchers.any(Ponto.class))).thenReturn(ponto);
		assertNotNull(pontoService.salvaPonto(idUsuario,"entrada"));
	}
	
	@Test
	public void testarSalvaPontoSaidaOK()
	{
		int idUsuario = 1;
		
		Ponto ultimoPonto = new Ponto();
		ultimoPonto.setTipoPonto("entrada");
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(usuario);
		Mockito.when(pontoRepository.findLastPontoByUser(idUsuario)).thenReturn(ultimoPonto);
		Mockito.when(pontoRepository.save(ArgumentMatchers.any(Ponto.class))).thenReturn(ponto);
		assertNotNull(pontoService.salvaPonto(idUsuario,"saida"));
	}
	
	@Test
	public void testarSalvaPontoNOKUsuarioNaoExiste()
	{
		int idUsuario = 1;
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(null);
		assertThrows(ResponseStatusException.class, () -> {
			pontoService.salvaPonto(idUsuario,"saida");
		});
	}
	
	@Test
	public void testarSalvaPontoNOKEntradaEntrada()
	{
		int idUsuario = 1;
		
		Ponto ultimoPonto = new Ponto();
		ultimoPonto.setTipoPonto("entrada");
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(usuario);
		Mockito.when(pontoRepository.findLastPontoByUser(idUsuario)).thenReturn(ultimoPonto);
		
		assertThrows(ResponseStatusException.class, () -> {
			pontoService.salvaPonto(idUsuario,"entrada");
		});
	}
	
	@Test
	public void testarSalvaPontoNOKSaidaSaida()
	{
		int idUsuario = 1;
		
		Ponto ultimoPonto = new Ponto();
		ultimoPonto.setTipoPonto("saida");
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(usuario);
		Mockito.when(pontoRepository.findLastPontoByUser(idUsuario)).thenReturn(ultimoPonto);
		
		assertThrows(ResponseStatusException.class, () -> {
			pontoService.salvaPonto(idUsuario,"saida");
		});
	}
	
	@Test
	public void testarSalvaPontoNOKPrimeiroPontoSaida()
	{
		int idUsuario = 1;
		
		Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(usuario);
		Mockito.when(pontoRepository.findLastPontoByUser(idUsuario)).thenReturn(null);
		
		assertThrows(ResponseStatusException.class, () -> {
			pontoService.salvaPonto(idUsuario,"saida");
		});
	}
}
