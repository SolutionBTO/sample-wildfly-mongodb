package br.com.sample.solutionbto.service;

import java.util.List;

import br.com.sample.solutionbto.model.Users;

public interface UsersService {
	
	List<Users> findAll();
	Users findById(String id);
	Users insert(Users user);
	Users update(Users user);
	void delete(String id);
	
}
