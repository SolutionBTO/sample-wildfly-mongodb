package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.Profiles;
import br.com.sample.solutionbto.repository_2.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesServiceImpl implements ProfilesService {

	@Autowired
	private ProfilesRepository profilesRepository;
	
	@Override
	public List<Profiles> findAll() {
		return profilesRepository.findAll();
	}

	@Override
	public Profiles findById(String id) {
		return profilesRepository.findById(id).orElse(null);
	}

	@Override
	public Profiles insert(Profiles profiles) {
		return profilesRepository.save(profiles);
	}
	
	@Override
	public Profiles update(Profiles profiles) {
		Profiles profilesExists = this.findById(profiles.getId());
		
		if(profilesExists == null)
			throw new RuntimeException("Profile is not exist!");
		
		return profilesRepository.save(profiles);
	}
	
	@Override
	public void delete(String id) {
		this.profilesRepository.deleteById(id);
	}

}
