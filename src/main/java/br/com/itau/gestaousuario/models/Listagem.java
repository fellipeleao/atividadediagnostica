package br.com.itau.gestaousuario.models;

import java.util.List;

public class Listagem {
	private List<Ponto> listagemPontos;
	private long totalHorasTrabalhadas;
	
	public List<Ponto> getListagemPontos() {
		return listagemPontos;
	}
	public void setListagemPontos(List<Ponto> listagemPontos) {
		this.listagemPontos = listagemPontos;
	}
	public long getTotalHorasTrabalhadas() {
		return totalHorasTrabalhadas;
	}
	public void setTotalHorasTrabalhadas(long totalHorasTrabalhadas) {
		this.totalHorasTrabalhadas = totalHorasTrabalhadas;
	}
}
