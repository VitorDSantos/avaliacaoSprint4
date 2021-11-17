package br.com.avaliacoes.testes.controllerDto;

import java.util.Date;

import br.com.avaliacoes.testes.modelo.Associados;

public class DetalhesAssociadosDto {
	private Long id;
	private String nome;
	private String cargo;
	private Date data_nasc;
	private String sexo;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public Date getData_nasc() {
		return data_nasc;
	}



	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public DetalhesAssociadosDto(Associados associados) {
		this.id = associados.getId();
		this.nome = associados.getNome();
		this.cargo = associados.getCargo();
		this.data_nasc = associados.getData_nasc();
		this.sexo = associados.getSexo();
	}
}
