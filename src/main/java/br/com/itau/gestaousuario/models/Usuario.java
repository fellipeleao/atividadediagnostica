package br.com.itau.gestaousuario.models;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Usuario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String nome;
	private String cpf;
	@Email
	private String email;
	private ZonedDateTime dataCadastro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ZonedDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(ZonedDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
