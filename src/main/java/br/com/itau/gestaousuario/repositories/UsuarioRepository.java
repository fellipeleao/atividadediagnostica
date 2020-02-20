package br.com.itau.gestaousuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.gestaousuario.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> 
{
	Usuario findById(int id);
}

