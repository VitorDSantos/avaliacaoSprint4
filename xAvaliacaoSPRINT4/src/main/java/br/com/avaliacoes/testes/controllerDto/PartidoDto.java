package br.com.avaliacoes.testes.controllerDto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.avaliacoes.testes.modelo.Partidos;

public class PartidoDto {
	private Long id;
	private String nomePartidos;
	private String sigla;
	private String ideologia;
	private Date dataFundacao;

	
	public PartidoDto(Partidos partidos) {
		this.id = partidos.getId();
		this.nomePartidos = partidos.getNomePartidos();
		this.sigla = partidos.getSigla();
		this.ideologia = partidos.getIdeologia();
		this.dataFundacao = partidos.getDataFundacao();
	}

	public Long getId() {
		return id;
	}

	public String getNomePartidos() {
		return nomePartidos;
	}

	public String getSigla() {
		return sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public static List<PartidoDto> converter(List<Partidos> partidos) {
		 
		return partidos.stream().map(PartidoDto::new).collect(Collectors.toList());
	}
	
	public static Page<PartidoDto> converterPage(Page<Partidos> partidos) {
		 
		return partidos.map(PartidoDto::new);
	}

}
