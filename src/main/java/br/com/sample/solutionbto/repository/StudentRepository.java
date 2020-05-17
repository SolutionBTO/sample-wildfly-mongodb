package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String>{}
