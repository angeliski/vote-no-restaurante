package br.com.votenorestaurante.rests.vos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {

	private String name;
	private String email;
	private List<Long> votes;

}
