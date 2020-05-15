package br.com.sample.solutionbto.controller;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.service.UsersService;

@Api(tags = "users")
@RestController
@RequestMapping("/api/v1")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getAll() {
		return usersService.findAll();
	}

	@GetMapping("/users/{id}")
	public Users getFindById(@PathVariable String id) {
		return usersService.findById(id);
	}

	@PostMapping("/users")
	public Users post(@RequestBody Users users) {
		usersService.passwordEncoder(users.getPassword());
		return usersService.insert(users);
	}

	@PutMapping("/users/{id}")
	public Users put(@RequestBody Users users, @PathVariable String id) {
		
		if(StringUtils.isEmpty(users.getId()) ||
				!users.getId().equals(id))
			throw new RuntimeException("Id on User is not matches!");
		
		return usersService.update(users);
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable String id) {
		usersService.delete(id);
	}
}
