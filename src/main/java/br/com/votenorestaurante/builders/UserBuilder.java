package br.com.votenorestaurante.builders;

import java.util.Date;

import lombok.Getter;
import br.com.votenorestaurante.entitys.User;

@Getter
public class UserBuilder {

	private User user;

	public UserBuilder() {
		user = new User();
	}

	public UserBuilder email(String email) {
		user.setEmail(email);
		return this;
	}

	public UserBuilder name(String name) {
		user.setName(name);
		return this;
	}

	public UserBuilder lastUpdate(Date lastUpdate) {
		user.setLastUpdate(lastUpdate);
		return this;
	}

	public User build() {
		return user;
	}

}
