package br.com.itau.gestaousuario.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.gestaousuario.models.Usuario;
import br.com.itau.gestaousuario.repositories.UsuarioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SpringBootTest
public class UsuarioServiceTest 
{
	@Autowired
	UsuarioService usuarioService;
	
	@MockBean
	UsuarioRepository usuarioRepository;

	Usuario usuario;
	
	@BeforeEach
	public void inicializarVariaveis()
	{	
		usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Fellipe Leão Marques Ferraz");
		usuario.setCpf("123.456.789-10");
		usuario.setEmail("teste@teste.com");
		usuario.setDataCadastro(ZonedDateTime.now());
	}
	
	@Test
	public void testarConsultaUsuarioUnicoNOK()
	{
		Mockito.when(usuarioRepository.findById(usuario.getId())).thenReturn(null);
		assertThrows(ResponseStatusException.class, () -> {
			usuarioService.consultaUsuarioUnico(usuario.getId());
		});
	}
	
	@Test
	public void testarConsultaUsuarioUnicoOK()
	{
		Mockito.when(usuarioRepository.findById(usuario.getId())).thenReturn(usuario);
		assertEquals(usuarioService.consultaUsuarioUnico(usuario.getId()).getStatusCode().value(), 200);
	}
	
	@Test
	public void testarSalvaUsuarioNOK()
	{
		Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
		assertThrows(ResponseStatusException.class, () -> {
			usuarioService.salvaUsuario(usuario);
		});
	}
	
	@Test
	public void testarSalvaUsuarioOK()
	{
		Usuario novoUsuario = new Usuario(); 
		novoUsuario.setCpf("123.456.789-10");
		novoUsuario.setNome("João Da Silva");
		novoUsuario.setEmail("joao@teste.com.br");
		novoUsuario.setDataCadastro(ZonedDateTime.now());
		
		Mockito.when(usuarioRepository.save(novoUsuario)).thenReturn(novoUsuario);
		assertEquals(usuarioService.salvaUsuario(novoUsuario).getStatusCode().value(), 201);		
	}	

	@Test
	public void testarAtualizaUsuarioNOKUsuarioNaoEncontrado()
	{
		Mockito.when(usuarioRepository.findById(usuario.getId())).thenReturn(null);
		assertThrows(ResponseStatusException.class, () -> {
			usuarioService.atualizaUsuario(usuario);
		});
	}
	
	@Test
	public void testarAtualizaUsuarioNOKDataCadastro()
	{
		Usuario usuarioParametro = new Usuario();
		usuarioParametro.setDataCadastro(ZonedDateTime.now());
		
		Mockito.when(usuarioRepository.findById(usuario.getId())).thenReturn(usuario);
		assertThrows(ResponseStatusException.class, () -> {
			usuarioService.atualizaUsuario(usuarioParametro);
		});
	}
	
	@Test
	public void testarAtualizaUsuarioOK()
	{
		Usuario usuarioParametro = new Usuario();
		usuarioParametro.setId(1);
		
		Mockito.when(usuarioRepository.findById(usuarioParametro.getId())).thenReturn(usuario);
		Mockito.when(usuarioRepository.save(usuarioParametro)).thenReturn(usuario);
		assertEquals(usuarioService.atualizaUsuario(usuarioParametro).getStatusCode().value(), 200);		
	}	
}
