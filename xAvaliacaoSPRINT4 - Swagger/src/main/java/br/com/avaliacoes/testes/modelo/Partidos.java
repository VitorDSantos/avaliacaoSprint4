package br.com.avaliacoes.testes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Partidos {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePartidos;
	private String sigla;
	private String ideologia;
	private Date dataFundacao;
	
	public Partidos() {
		// TODO Auto-generated constructor stub
	}

	public Partidos(Long id, String nomePartidos, String sigla, String ideologia, Date dataFundacao) {
		this.id = id;
		this.nomePartidos = nomePartidos;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}



	public Partidos(String nomePartidos, String sigla, String ideologia, Date dataFundacao) {
		this.nomePartidos = nomePartidos;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partidos other = (Partidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



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
	
}
