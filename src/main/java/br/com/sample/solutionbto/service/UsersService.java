package br.com.sample.solutionbto.service;

import java.util.List;

import br.com.sample.solutionbto.model.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;

public interface UsersService {
	
	String passwordEncoder(String password);
	List<Users> findAll();
	List<Users> findByFirstNameLikeIgnoreCase(String firstName);
	List<Users> findAllBy(TextCriteria criteria, Pageable pages);
	Users findById(String id);
	Users insert(Users user);
	Users update(Users user);
	void delete(String id);
	
}
