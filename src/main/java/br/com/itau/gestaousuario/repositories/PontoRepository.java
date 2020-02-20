package br.com.itau.gestaousuario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.itau.gestaousuario.models.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Integer> 
{
	List<Ponto> findAllById(int id);
	
	@Query("select t from Ponto t where t.usuario.id = :idUsuario order by data_ponto desc")
	List<Ponto> findAllPontoByUser(int idUsuario);
	
	@Query(value = "select * from ponto where usuario_id = :idUsuario order by data_ponto desc limit 1", nativeQuery = true)
	Ponto findLastPontoByUser(int idUsuario);
}

