package br.com.sample.solutionbto.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sample.solutionbto.model.Users;

public interface UsersRepository extends MongoRepository<Users, Integer>{

	Users findByFirstName(String firstName);
	List<Users> findByLastName(String lastName);
}
