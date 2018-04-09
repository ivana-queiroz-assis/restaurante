package br.com.ivana.restaurante.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class VotoFuncionario {

	@Id
	@GeneratedValue
	private long id;
	
	
	@OneToOne
	private Funcionario func;
	
	@NotEmpty
	private String data;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public VotoFuncionario() {
		super();
	}
	
	public Funcionario getFunc() {
		return func;
	}
	public void setFunc(Funcionario func) {
		this.func = func;
	}
	public VotoFuncionario(long id, @NotEmpty Funcionario func, @NotEmpty String data) {
		super();
		this.id = id;
		this.func = func;
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
}
