package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.Module;

import java.util.List;

public interface ModuleService {

	List<Module> findAll();
	Module findById(String id);
	Module insert(Module module);
	Module update(Module module);
	void delete(String id);
	
}
