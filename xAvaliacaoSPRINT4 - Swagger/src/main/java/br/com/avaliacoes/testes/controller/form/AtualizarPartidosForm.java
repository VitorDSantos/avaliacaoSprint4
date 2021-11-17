package br.com.avaliacoes.testes.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.avaliacoes.testes.modelo.Partidos;
import br.com.avaliacoes.testes.repository.PartidosRepository;

public class AtualizarPartidosForm {
	@NotNull @NotEmpty 
	private String nomePartidos;
	@NotNull @NotEmpty 
	private String sigla;
	@NotNull @NotEmpty 
	private String ideologia;
	@NotNull @NotEmpty 
	private Date dataFundacao;

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

	public Partidos atualizar(Long id, PartidosRepository partidosRepository) {
		Partidos partidos = partidosRepository.getOne(id);
		partidos.setNomePartidos(this.nomePartidos);
		partidos.setSigla(this.sigla);
		partidos.setIdeologia(this.ideologia);
		partidos.setDataFundacao(this.dataFundacao);
		
		
		return partidos;
	}
	
}
