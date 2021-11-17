package br.com.avaliacoes.testes.controllerDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;


import br.com.avaliacoes.testes.modelo.Associados;

public class AssociadosDto {
	private String nome;
	private String cargo;
	private Date data_nasc;
	private String sexo;
	
	public AssociadosDto(Associados associadaos) {
		this.nome = associadaos.getNome();
		this.cargo = associadaos.getCargo();
		this.data_nasc = associadaos.getData_nasc();
		this.sexo = associadaos.getSexo();
	}

	public String getNome() {
		return nome;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public String getSexo() {
		return sexo;
	}
	
	public String getCargo() {
		return cargo;
	}

	public static List<AssociadosDto> converter(List<Associados> associados) {
		 
		return associados.stream().map(AssociadosDto::new).collect(Collectors.toList());
	}
	
	public static Page<AssociadosDto> converterPage(Page<Associados> associados) {
		 
		return associados.map(AssociadosDto::new);
	}
}
