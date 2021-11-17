package br.com.avaliacoes.testes.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.avaliacoes.testes.modelo.Associados;
import br.com.avaliacoes.testes.modelo.Partidos;
import br.com.avaliacoes.testes.repository.AssociadosRepository;
import br.com.avaliacoes.testes.repository.PartidosRepository;


public class AssociadosForm {
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String cargo;
	

	private Date data_nasc;
	
	@NotNull @NotEmpty
	private String sexo;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Associados converter() {
		return new Associados(nome,cargo,data_nasc,sexo) ;
	}
	
	public Associados atualizar(Long id, AssociadosRepository associadosRepository) {
		Associados associados = associadosRepository.getOne(id);
		
		associados.setNome(this.nome);
		associados.setCargo(this.cargo);
		associados.setData_nasc(this.data_nasc);
		associados.setSexo(this.sexo);

		
		return associados;
	}
}
