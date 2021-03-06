package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.FileGridFS;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileGridFsRepository extends MongoRepository<FileGridFS, String> {
    FileGridFS findByFileName(String fileName);
}
