package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.service.DiaryService;
import br.com.sample.solutionbto.service.ModuleService;
import br.com.sample.solutionbto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ModuleService moduleService;

	@GetMapping(value = {"","/"})
	public List<Diary> getAll() {
		return diaryService.findAll();
	}

	@GetMapping("/{id}")
	public Diary getFindById(@PathVariable String id) {
		return diaryService.findById(id);
	}

	@PostMapping
	public Diary post(@RequestBody Diary Diary) {
		return diaryService.insert(Diary);
	}

	@PutMapping("/{id}")
	public Diary put(@RequestBody Diary Diary, @PathVariable String id) {
		
		if(StringUtils.isEmpty(Diary.getId()) ||
				!Diary.getId().equals(id))
			throw new RuntimeException("Id on Diary is not matches!");
		
		return diaryService.update(Diary);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		diaryService.delete(id);
	}

	@GetMapping("/{studentId}/student")
	public List<Diary> findByStudent(@PathVariable String studentId) {
		Student student = studentService.findById(studentId);

		return diaryService.findByStudent(student);
	}

	@GetMapping("/{moduleId}/module")
	public List<Diary> findByModule(@PathVariable String moduleId) {
		Module module = moduleService.findById(moduleId);

		return diaryService.findByModule(module);
	}

	@GetMapping("/{beginDate}/{endDate}")
	public List<Diary> findByCreateDateBetween(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate beginDate,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate endDate){

		return diaryService.findByCreateDateBetween(beginDate, endDate);
	}
}
