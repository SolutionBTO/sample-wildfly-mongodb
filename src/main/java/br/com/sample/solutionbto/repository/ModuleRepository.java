package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ModuleRepository extends MongoRepository<Module, String>{}
