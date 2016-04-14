package br.com.votenorestaurante.repositorys;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.votenorestaurante.Application;
import br.com.votenorestaurante.entitys.Restaurant;
import br.com.votenorestaurante.rests.vos.UserVO;
import br.com.votenorestaurante.rests.vos.VoteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
@Transactional
public class VoteBusinessRepositoryTest {

	@Autowired
	private VoteBusinessRepository businessRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	private Restaurant restaurant;
	private UserVO vo;

	@Before
	public void setUp() throws Exception {
		restaurant = restaurantRepository.findOne(1L);
		vo = new UserVO();
	}

	@After
	public void tearDown() throws Exception {
		restaurant = null;
		vo = null;
	}

	@Test
	public void testMakeSingleVote() {
		vo.setVotes(Collections.singletonList(restaurant.getId()));

		businessRepository.vote(vo);

		List<VoteVO> votes = businessRepository.findAll();
		long count = votes
				.stream()
				.filter(restaurantVoted -> restaurant.getName().equals(
						restaurantVoted.getName()))
				.filter(restaurantVoted -> restaurantVoted.getVotes() == 1)
				.count();

		Assert.assertEquals("Restaurant wasn't voted", 1L, count);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDontMakeVote() {
		vo.setVotes(Collections.emptyList());

		businessRepository.vote(vo);

		Assert.assertFalse("Error expected", true);
	}

	@Test
	public void testFindAllVotes() {
		List<VoteVO> restaurants = businessRepository.findAll();
		Assert.assertEquals("findAll don't return correct", 5,
				restaurants.size());
	}

}
