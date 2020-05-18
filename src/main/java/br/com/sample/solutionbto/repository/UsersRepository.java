package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<Users, String>{

	List<Users> findByFirstNameLikeIgnoreCase(String firstName);
    List<Users> findAllBy(TextCriteria criteria, Pageable pages);
	Users findByEmail(String email);
}
