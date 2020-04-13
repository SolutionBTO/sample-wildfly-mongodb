package br.com.sample.solutionbto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
	
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
		
		return usersRepository.save(user);
	}
	
	@Override
	public void delete(String id) {
		this.usersRepository.deleteById(id);
	}

}
