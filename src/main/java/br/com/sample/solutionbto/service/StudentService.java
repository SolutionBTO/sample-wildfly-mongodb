package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.Student;

import java.util.List;

public interface StudentService {

	List<Student> findAll();
	Student findById(String id);
	Student insert(Student student);
	Student update(Student student);
	void delete(String id);
	
}
