package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Users;
import br.com.sample.solutionbto.service.UsersService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

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

	@GetMapping("/users/{firstName}/like")
	public List<Users> listLike(@PathVariable String firstName) {
		return usersService.findByFirstNameLikeIgnoreCase(firstName);
	}

	@GetMapping("/users/{name}/full-text-search")
	public List<Users> listFullText(@PathVariable String name) {
		Pageable pages = PageRequest.of( 0, 10, Sort.by(new Sort.Order(ASC, "score")));
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(name);

		return usersService.findAllBy(criteria, pages);
	}

	@PostMapping("/users")
	public Users post(@RequestBody Users users) {
		users.setPassword(usersService.passwordEncoder(users.getPassword()));
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
