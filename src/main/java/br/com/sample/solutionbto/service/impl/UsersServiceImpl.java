package br.com.sample.solutionbto.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import br.com.sample.solutionbto.service.UsersService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.repository.UsersRepository;
import org.springframework.util.DigestUtils;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository usersRepository;

	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public String passwordEncoder(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

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
		user.setCreated(LocalDateTime.now());
		user.setPassword(passwordEncoder(user.getPassword()));
		return usersRepository.save(user);
	}
	
	@Override
	public Users update(Users user) {
		Users usersExists = this.findById(user.getId());
		
		if(usersExists == null)
			throw new RuntimeException("User is not exist!");
		
		// not alter credentials
		user.setPassword(usersExists.getEmail());
		user.setPassword(usersExists.getPassword());
		user.setModified(LocalDateTime.now());
		
		return usersRepository.save(user);
	}
	
	@Override
	public void delete(String id) {
		this.usersRepository.deleteById(id);
	}

	@Override
	public List<Users> findByFirstNameLikeIgnoreCase(String firstName) {
		return this.usersRepository.findByFirstNameLikeIgnoreCase(firstName);
	}

	@Override
	public List<Users> findAllBy(TextCriteria criteria, Pageable pages) {
		return this.usersRepository.findAllBy(criteria,pages);
	}
}
