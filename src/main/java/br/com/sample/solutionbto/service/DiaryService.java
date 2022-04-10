package br.com.sample.solutionbto.service;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;

import java.time.LocalDate;
import java.util.List;

public interface DiaryService {

	List<Diary> findAll();
	Diary findById(String id);
	Diary insert(Diary diary);
	Diary update(Diary diary);
	void delete(String id);
	List<Diary> findByStudent(Student student);
	List<Diary> findByModule(Module module);
	List<Diary> findByDatePresenceBetween(LocalDate dateBegin , LocalDate dateEnd);
}
