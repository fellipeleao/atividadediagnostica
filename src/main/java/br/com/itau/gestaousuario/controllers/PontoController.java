package br.com.itau.gestaousuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.gestaousuario.models.Listagem;
import br.com.itau.gestaousuario.models.Ponto;
import br.com.itau.gestaousuario.services.PontoService;

@RestController
@RequestMapping("/api")
public class PontoController 
{
	@Autowired
	PontoService pontoService;

	@PostMapping("/ponto/entrada")
	public Ponto salvaPontoEntrada(@RequestBody Ponto ponto)
	{
		return pontoService.salvaPonto(ponto.getUsuario().getId(), "entrada");
	}
	
	@PostMapping("/ponto/saida")
	public Ponto salvaPontoSaida(@RequestBody Ponto ponto)
	{
		return pontoService.salvaPonto(ponto.getUsuario().getId(), "saida");
	}
	
	@GetMapping("/ponto/listagem/{idUsuario}")
	public ResponseEntity<Listagem> consultaPontoUsuario(@PathVariable(value="idUsuario") int idUsuario)
	{
		return pontoService.consultaPontoUsuario(idUsuario);
	}
}
