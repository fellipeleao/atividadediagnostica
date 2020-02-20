package br.com.itau.gestaousuario.models;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Ponto 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private ZonedDateTime dataPonto;
	@NotNull
	private String tipoPonto;
	
	@ManyToOne
	private Usuario usuario;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ZonedDateTime getDataPonto() {
		return dataPonto;
	}

	public void setDataPonto(ZonedDateTime dataPonto) {
		this.dataPonto = dataPonto;
	}

	public String getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
