package br.com.sample.solutionbto.repository_1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sample.solutionbto.model.Users;

@Repository
@Transactional
public interface UsersRepository extends MongoRepository<Users, String>{
	Users findByName(String name);
	Users findByEmail(String email);
}
