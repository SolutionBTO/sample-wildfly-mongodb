package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String>{

	Users findByFirstName(String firstName);
	Users findByLastName(String firstName);
	Users findByEmail(String email);
}
