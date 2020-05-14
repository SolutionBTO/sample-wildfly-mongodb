package br.com.sample.solutionbto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = {"","/"})
	public List<Users> getAll() {
		return usersService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Users getFindById(@PathVariable String id) {
		return usersService.findById(id);
	}

	@PostMapping
	public Users post(@RequestBody Users users) {
		usersService.passwordEncoder(users.getPassword());
		return usersService.insert(users);
	}

	@PutMapping(value = "/{id}")
	public Users put(@RequestBody Users users, @PathVariable String id) {
		
		if(StringUtils.isEmpty(users.getId()) ||
				!users.getId().equals(id))
			throw new RuntimeException("Id on User is not matches!");
		
		return usersService.update(users);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		usersService.delete(id);
	}
}
