package br.com.votenorestaurante.rests;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.votenorestaurante.builders.UserBuilder;
import br.com.votenorestaurante.entitys.User;
import br.com.votenorestaurante.repositorys.UserRepository;
import br.com.votenorestaurante.repositorys.VoteBusinessRepository;
import br.com.votenorestaurante.rests.vos.UserVO;
import br.com.votenorestaurante.rests.vos.VoteVO;

@RestController
@RequestMapping("/vote")
public class VoteRest {

	@Autowired
	private VoteBusinessRepository votoBusiness;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = { RequestMethod.POST })
	public void registerVotes(@RequestBody UserVO vo) {
		User user = userRepository.findByEmail(vo.getEmail());

		if (user == null) {
			UserBuilder builder = new UserBuilder();
			builder.email(vo.getEmail()).name(vo.getName())
					.lastUpdate(new Date());

			user = builder.build();

			user = userRepository.save(user);
		}

		votoBusiness.vote(vo);
	}

	@RequestMapping(method = { RequestMethod.GET })
	public List<VoteVO> votes() {
		return votoBusiness.findAll();
	}

}
