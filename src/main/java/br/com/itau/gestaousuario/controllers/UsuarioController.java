package br.com.itau.gestaousuario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.gestaousuario.models.Usuario;
import br.com.itau.gestaousuario.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController 
{
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listaTodosUsuarios()
	{
		return usuarioService.listaTodosUsuarios();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> consultaUsuarioUnico(@PathVariable(value="id") int id)
	{
		return usuarioService.consultaUsuarioUnico(id);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario)
	{
		return usuarioService.salvaUsuario(usuario);
	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario)
	{
		return usuarioService.atualizaUsuario(usuario);
	}
}
