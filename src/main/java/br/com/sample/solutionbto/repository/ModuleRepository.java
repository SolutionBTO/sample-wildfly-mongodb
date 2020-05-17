package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, String>{}
