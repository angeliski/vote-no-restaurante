package br.com.votenorestaurante.rests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.votenorestaurante.entitys.Restaurant;
import br.com.votenorestaurante.repositorys.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRest {

	@Autowired
	private RestaurantRepository repository;

	@RequestMapping(method = { RequestMethod.GET })
	public List<Restaurant> all() {
		List<Restaurant> restaurants = new ArrayList<>();
		Iterable<Restaurant> all = repository.findAll();
		all.forEach(restaurant -> restaurants.add(restaurant));
		return restaurants;
	}

}
