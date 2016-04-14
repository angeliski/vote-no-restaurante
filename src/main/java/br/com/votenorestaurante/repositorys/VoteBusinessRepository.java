package br.com.votenorestaurante.repositorys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votenorestaurante.entitys.Restaurant;
import br.com.votenorestaurante.rests.vos.UserVO;
import br.com.votenorestaurante.rests.vos.VoteVO;

@Service
public class VoteBusinessRepository {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public void vote(UserVO vo) {
		if (vo.getVotes().isEmpty()) {
			throw new IllegalArgumentException(
					"You must vote for at least one restaurant");
		}

		Iterable<Restaurant> restaurants = restaurantRepository.findAll(vo
				.getVotes());

		restaurants.forEach(restaurant -> restaurant.increaseVote());
		restaurantRepository.save(restaurants);
	}

	public List<VoteVO> findAll() {
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
		List<VoteVO> votes = new ArrayList<>();

		restaurants.forEach(restaurant -> {
			VoteVO vote = new VoteVO();
			vote.setName(restaurant.getName());
			vote.setVotes(restaurant.getVotes());
			votes.add(vote);
		});

		return votes;
	}

}
