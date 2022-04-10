package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.repository.DiaryRepository;
import br.com.sample.solutionbto.service.DiaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

	private DiaryRepository diaryRepository;

	public DiaryServiceImpl(DiaryRepository diaryRepository) {
		this.diaryRepository = diaryRepository;
	}

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
		diary.setCreated(LocalDateTime.now());
		return diaryRepository.save(diary);
	}
	
	@Override
	public Diary update(Diary diary) {
		diary.setModified(LocalDateTime.now());
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
	public List<Diary> findByDatePresenceBetween(LocalDate dateBegin, LocalDate dateEnd) {
		return this.diaryRepository.findByDatePresenceBetween(dateBegin,dateEnd);
	}
}
