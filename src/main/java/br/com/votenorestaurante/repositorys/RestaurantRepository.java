package br.com.votenorestaurante.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.votenorestaurante.entitys.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
