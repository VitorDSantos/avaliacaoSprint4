package br.com.avaliacoes.testes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Associados {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Associados(@NotNull @NotEmpty String nome, @NotNull @NotEmpty String cargo, @NotNull @NotEmpty Date data_nasc, @NotNull @NotEmpty String sexo) {
		this.nome = nome;
		this.cargo = cargo;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
	}
	
	public Associados(Long id, String nome, String cargo,Date data_nasc, String sexo) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
	}
	
	public Associados() {
		// TODO Auto-generated constructor stub
	}
	
	
}
