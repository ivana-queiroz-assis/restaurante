package br.com.ivana.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ivana.restaurante.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario,String>{
	
	Funcionario findById(long id);
	
	
}
