package br.com.ivana.restaurante.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Funcionario implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	private String nome;
	
	
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(long id, @NotEmpty String nome, @NotEmpty String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
