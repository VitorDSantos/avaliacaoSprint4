package br.com.avaliacoes.testes.controller.form;

import java.util.Date;

import br.com.avaliacoes.testes.modelo.Associados;
import br.com.avaliacoes.testes.modelo.Partidos;
import br.com.avaliacoes.testes.repository.AssociadosRepository;
import br.com.avaliacoes.testes.repository.PartidosRepository;

public class PartidoForm {
	private String nome_partidos;
	private String sigla;
	private String ideologia;
	private Date dataFundacao;
	
	
	public Partidos converter() {
		return new Partidos(nome_partidos,sigla,ideologia,dataFundacao) ;
	}



	public Partidos atualizar(Long id, PartidosRepository partidosRepository) {
		Partidos partidos = partidosRepository.getOne(id);
		partidos.setNomePartidos(this.nome_partidos);
		partidos.setSigla(this.sigla);
		partidos.setIdeologia(this.ideologia);
		partidos.setDataFundacao(this.dataFundacao);
		
		
		return partidos;
	}



	public String getNome_partidos() {
		return nome_partidos;
	}



	public void setNome_partidos(String nome_partidos) {
		this.nome_partidos = nome_partidos;
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
