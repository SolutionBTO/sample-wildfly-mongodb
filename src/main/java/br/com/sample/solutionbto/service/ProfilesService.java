package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.Profiles;

import java.util.List;

public interface ProfilesService {

	List<Profiles> findAll();
	Profiles findById(String id);
	Profiles insert(Profiles profiles);
	Profiles update(Profiles profiles);
	void delete(String id);
	
}
