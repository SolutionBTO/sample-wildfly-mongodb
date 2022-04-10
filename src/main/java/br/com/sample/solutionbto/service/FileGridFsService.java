package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.FileGridFS;
import br.com.sample.solutionbto.model.Student;

import java.util.List;

public interface FileGridFsService {

	List<FileGridFS> findAll();
	FileGridFS findById(String id);
	FileGridFS findByFileName(String id);
	FileGridFS insert(FileGridFS student);
	FileGridFS update(FileGridFS student);
	void delete(String id);
	
}
