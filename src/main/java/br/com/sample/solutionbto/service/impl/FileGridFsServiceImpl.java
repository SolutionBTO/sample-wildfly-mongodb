package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.FileGridFS;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.repository.FileGridFsRepository;
import br.com.sample.solutionbto.repository.ModuleRepository;
import br.com.sample.solutionbto.service.FileGridFsService;
import br.com.sample.solutionbto.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileGridFsServiceImpl implements FileGridFsService {

	@Autowired
	private FileGridFsRepository fileGridFsRepository;

	@Override
	public List<FileGridFS> findAll() {
		return fileGridFsRepository.findAll();
	}

	@Override
	public FileGridFS findById(String id) {
		return fileGridFsRepository.findById(id).orElse(null);
	}

	@Override
	public FileGridFS findByFileName(String fileName) {
		return fileGridFsRepository.findByFileName(fileName);
	}

	@Override
	public FileGridFS insert(FileGridFS fileGridFS) {
		return fileGridFsRepository.save(fileGridFS);
	}
	
	@Override
	public FileGridFS update(FileGridFS fileGridFS) {
		return fileGridFsRepository.save(fileGridFS);
	}
	
	@Override
	public void delete(String id) {
		this.fileGridFsRepository.deleteById(id);
	}
}
