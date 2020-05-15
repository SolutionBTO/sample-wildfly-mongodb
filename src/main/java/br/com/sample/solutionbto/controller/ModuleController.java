package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.service.ModuleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "module")
@RestController
@RequestMapping("/api/v1")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@GetMapping("/module")
	public List<Module> getAll() {
		return moduleService.findAll();
	}

	@GetMapping("/module/{id}")
	public Module getFindById(@PathVariable String id) {
		return moduleService.findById(id);
	}

	@PostMapping("/module")
	public Module post(@RequestBody Module module) {
		return moduleService.insert(module);
	}

	@PutMapping("/module/{id}")
	public Module put(@RequestBody Module module, @PathVariable String id) {
		
		if(StringUtils.isEmpty(module.getId()) ||
				!module.getId().equals(id))
			throw new RuntimeException("Id on Module is not matches!");
		
		return moduleService.update(module);
	}

	@DeleteMapping("/module/{id}")
	public void delete(@PathVariable String id) {
		moduleService.delete(id);
	}
}
