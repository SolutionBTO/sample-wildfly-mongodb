package br.com.sample.solutionbto.service.impl;

import java.util.Base64;
import java.util.List;

import br.com.sample.solutionbto.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	public String passwordEncoder(String password) {
		return new String(Base64.getEncoder().encode(password.getBytes()));
	}
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Users findById(String id) {
		return usersRepository.findById(id).orElse(null);
	}

	@Override
	public Users insert(Users user) {
		return usersRepository.save(user);
	}
	
	@Override
	public Users update(Users user) {
		Users usersExists = this.findById(user.getId());
		
		if(usersExists == null)
			throw new RuntimeException("User is not exist!");
		
		// not alter password
		user.setPassword(usersExists.getPassword());
		
		return usersRepository.save(user);
	}
	
	@Override
	public void delete(String id) {
		this.usersRepository.deleteById(id);
	}

}
