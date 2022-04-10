package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.repository.StudentRepository;
import br.com.sample.solutionbto.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student insert(Student student) {
		student.setCreated(LocalDateTime.now());
		return studentRepository.save(student);
	}
	
	@Override
	public Student update(Student student) {
		student.setModified(LocalDateTime.now());
		return studentRepository.save(student);
	}
	
	@Override
	public void delete(String id) {
		this.studentRepository.deleteById(id);
	}
}
