package br.com.sample.solutionbto.repository_2;

import br.com.sample.solutionbto.model.Profiles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProfilesRepository extends MongoRepository<Profiles, String>{

}
