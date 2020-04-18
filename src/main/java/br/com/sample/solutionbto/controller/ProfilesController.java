package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Profiles;
import br.com.sample.solutionbto.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilesController {

	@Autowired
	private ProfilesService profilesService;
	
	@GetMapping(value = "profiles")
	public List<Profiles> getAll() {
		return profilesService.findAll();
	}

	@GetMapping(value = "profiles/{id}")
	public Profiles getFindById(@PathVariable String id) {
		return profilesService.findById(id);
	}

	@PostMapping(value = "profiles")
	public Profiles post(@RequestBody Profiles profiles) {
		return profilesService.insert(profiles);
	}

	@PutMapping(value = "profiles/{id}")
	public Profiles put(@RequestBody Profiles profiles, @PathVariable String id) {
		
		if(StringUtils.isEmpty(profiles.getId()) ||
				!profiles.getId().equals(id))
			throw new RuntimeException("Id on Profile is not matches!");
		
		return profilesService.update(profiles);
	}

	@DeleteMapping(value = "profiles/{id}")
	public void delete(@PathVariable String id) {
		profilesService.delete(id);
	}
}
