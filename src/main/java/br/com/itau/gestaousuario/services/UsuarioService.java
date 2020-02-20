package br.com.itau.gestaousuario.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.gestaousuario.models.Usuario;
import br.com.itau.gestaousuario.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ResponseEntity<List<Usuario>> listaTodosUsuarios()
	{
		return new ResponseEntity<List<Usuario>>(usuarioRepository.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<Usuario> consultaUsuarioUnico(int id)
	{
		Usuario usuario = usuarioRepository.findById(id);
		
		if(usuario != null)
		{
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		else
		{
	    	throw new ResponseStatusException(
	    	          HttpStatus.NOT_FOUND, "Usuário não encontrado - Verifique o parâmetro Id informado");
		}
		
	}
	
	public ResponseEntity<Usuario> salvaUsuario(Usuario usuario)
	{
	    if(usuario.getId() != 0) 
	    {
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "O Id não pode ser definido ao criar um usuário - Remova o parâmetro Id");
	    }
	    
	    if(usuario.getDataCadastro() == null)
	    {
	    	usuario.setDataCadastro(ZonedDateTime.now());
	    }
	    
		return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Usuario> atualizaUsuario(Usuario usuario)
	{
		Usuario usuarioDB = usuarioRepository.findById(usuario.getId());
		
		if(usuarioDB == null){
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "Usuário não encontrado - Verifique o parâmetro Id informado");
		}
		
		if(usuario.getDataCadastro() != null){
	    	throw new ResponseStatusException(
	    	          HttpStatus.BAD_REQUEST, "Não é possível alterar a data de cadastro - Remova o parâmetro dataCadastro");
		}
		
		usuario.setDataCadastro(usuarioDB.getDataCadastro());
		
		return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.OK);
	}
}
