package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.repository.DiaryRepository;
import br.com.sample.solutionbto.repository.DiaryRepository;
import br.com.sample.solutionbto.service.DiaryService;
import br.com.sample.solutionbto.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;
	
	@Override
	public List<Diary> findAll() {
		return diaryRepository.findAll();
	}

	@Override
	public Diary findById(String id) {
		return diaryRepository.findById(id).orElse(null);
	}

	@Override
	public Diary insert(Diary diary) {
		return diaryRepository.save(diary);
	}
	
	@Override
	public Diary update(Diary diary) {
		return diaryRepository.save(diary);
	}
	
	@Override
	public void delete(String id) {
		this.diaryRepository.deleteById(id);
	}

	@Override
	public List<Diary> findByStudent(Student student) {
		return this.diaryRepository.findByStudent(student);
	}

	@Override
	public List<Diary> findByModule(Module module) {
		return this.diaryRepository.findByModule(module);
	}

	@Override
	public List<Diary> findByCreateDateBetween(LocalDate dateBegin, LocalDate dateEnd) {
		return this.diaryRepository.findByCreateDateBetween(dateBegin,dateEnd);
	}
}
