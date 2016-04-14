package br.com.votenorestaurante.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.votenorestaurante.entitys.Restaurant;
import br.com.votenorestaurante.entitys.User;
import br.com.votenorestaurante.repositorys.RestaurantRepository;

@RestController
public class HomeController {

	@Autowired
	private RestaurantRepository userRepository;

	@RequestMapping(method = { RequestMethod.POST }, value = "/insert")
	public User insert() {

		return null;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = "/all")
	public List<Restaurant> listAll() {
		Iterable<Restaurant> allUser = userRepository.findAll();
		List<Restaurant> users = new ArrayList<>();
		// TODO simple convertion. Will be better
		for (Restaurant user : allUser) {
			users.add(user);
		}

		return users;
	}

}
