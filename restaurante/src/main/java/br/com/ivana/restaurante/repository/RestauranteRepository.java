package br.com.ivana.restaurante.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ivana.restaurante.model.Restaurante;

public interface  RestauranteRepository extends CrudRepository<Restaurante, String>{

}
