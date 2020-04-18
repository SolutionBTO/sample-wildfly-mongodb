package br.com.sample.solutionbto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = "users")
	public List<Users> getAll() {
		return usersService.findAll();
	}

	@GetMapping(value = "users/{id}")
	public Users getFindById(@PathVariable String id) {
		return usersService.findById(id);
	}

	@PostMapping(value = "users")
	public Users post(@RequestBody Users users) {
		usersService.passwordEncoder(users.getPassword());
		return usersService.insert(users);
	}

	@PutMapping(value = "users/{id}")
	public Users put(@RequestBody Users users, @PathVariable String id) {
		
		if(StringUtils.isEmpty(users.getId()) ||
				!users.getId().equals(id))
			throw new RuntimeException("Id on User is not matches!");
		
		return usersService.update(users);
	}

	@DeleteMapping(value = "users/{id}")
	public void delete(@PathVariable String id) {
		usersService.delete(id);
	}
}
