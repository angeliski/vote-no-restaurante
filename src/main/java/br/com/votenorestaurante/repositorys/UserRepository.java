package br.com.votenorestaurante.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.votenorestaurante.entitys.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

}
