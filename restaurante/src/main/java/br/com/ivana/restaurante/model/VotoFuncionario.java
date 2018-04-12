package br.com.ivana.restaurante.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;

@Entity
public class VotoFuncionario {

	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty
	private String idFunc;
	
	@NotEmpty
	private String idRest;
	
	private String data;
	
	public long getId() {
		return id;
	}
	public String getIdRest() {
		return idRest;
	}
	public void setIdRest(String idRest) {
		this.idRest = idRest;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public VotoFuncionario() {
		super();
	}	
	
	
	public VotoFuncionario(long id, @NotEmpty String idFunc, @NotEmpty String idRest, String data) {
		super();
		this.id = id;
		this.idFunc = idFunc;
		this.idRest = idRest;
		this.data = data;
	}
	public String getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(String idFunc) {
		this.idFunc = idFunc;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}
