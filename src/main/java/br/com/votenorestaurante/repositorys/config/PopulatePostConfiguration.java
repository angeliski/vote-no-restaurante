package br.com.votenorestaurante.repositorys.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.votenorestaurante.config.PostConfiguration;
import br.com.votenorestaurante.entitys.Restaurant;
import br.com.votenorestaurante.repositorys.RestaurantRepository;

@Component
public class PopulatePostConfiguration implements PostConfiguration {

	@Autowired
	private RestaurantRepository restauranteRepository;

	@Override
	public void configure() {
		long count = restauranteRepository.count();

		if (count < 5) {
			restauranteRepository.deleteAll();

			List<Restaurant> restaurants = new ArrayList<>();

			Restaurant restaurant = new Restaurant();
			restaurant.setName("McDonald's");
			restaurant.setImgUrl("resources/img/mc.png");
			restaurants.add(restaurant);

			restaurant = new Restaurant();
			restaurant.setName("Burger King");
			restaurant.setImgUrl("resources/img/burger_king.jpg");
			restaurants.add(restaurant);

			restaurant = new Restaurant();
			restaurant.setName("Spolleto");
			restaurant.setImgUrl("resources/img/spolleto.jpg");
			restaurants.add(restaurant);

			restaurant = new Restaurant();
			restaurant.setName("Sushi Isao");
			restaurant.setImgUrl("resources/img/sushi_isao.gif");
			restaurants.add(restaurant);

			restaurant = new Restaurant();
			restaurant.setName("Fogo de chão");
			restaurant.setImgUrl("resources/img/fogo_de_chao.png");
			restaurants.add(restaurant);

			restauranteRepository.save(restaurants);

		}

	}

}
