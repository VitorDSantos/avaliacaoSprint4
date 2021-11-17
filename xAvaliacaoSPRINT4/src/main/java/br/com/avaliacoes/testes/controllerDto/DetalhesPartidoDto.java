package br.com.avaliacoes.testes.controllerDto;

import java.util.Date;

import br.com.avaliacoes.testes.modelo.Partidos;

public class DetalhesPartidoDto {
	private Long id;
	private String nomePartidos;
	private String sigla;
	private String ideologia;
	private Date dataFundacao;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomePartidos() {
		return nomePartidos;
	}


	public void setNomePartidos(String nomePartidos) {
		this.nomePartidos = nomePartidos;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public String getIdeologia() {
		return ideologia;
	}


	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}


	public Date getDataFundacao() {
		return dataFundacao;
	}


	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}


	public DetalhesPartidoDto(Partidos partidos) {
		this.id = partidos.getId();
		this.nomePartidos = partidos.getNomePartidos();
		this.sigla = partidos.getSigla();
		this.ideologia = partidos.getIdeologia();
		this.dataFundacao = partidos.getDataFundacao();
	}
}
