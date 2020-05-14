package br.com.sample.solutionbto.repository;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface DiaryRepository extends MongoRepository<Diary, String>{

	List<Diary> findByStudent(Student student);
	List<Diary> findByModule(Module module);
	List<Diary> findByCreateDateBetween(LocalDate dateBegin , LocalDate dateEnd);

}
