package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.repository.ModuleRepository;
import br.com.sample.solutionbto.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Override
	public List<Module> findAll() {
		return moduleRepository.findAll();
	}

	@Override
	public Module findById(String id) {
		return moduleRepository.findById(id).orElse(null);
	}

	@Override
	public Module insert(Module module) {
		return moduleRepository.save(module);
	}
	
	@Override
	public Module update(Module module) {
		return moduleRepository.save(module);
	}
	
	@Override
	public void delete(String id) {
		this.moduleRepository.deleteById(id);
	}
}
