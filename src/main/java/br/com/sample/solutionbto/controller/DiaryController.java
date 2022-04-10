package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Diary;
import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.service.DiaryService;
import br.com.sample.solutionbto.service.ModuleService;
import br.com.sample.solutionbto.service.StudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Api(tags = "diary")
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ModuleService moduleService;

	@GetMapping("/diary")
	public List<Diary> getAll() {
		return diaryService.findAll();
	}

	@GetMapping("/diary/{id}")
	public Diary getFindById(@PathVariable String id) {
		return diaryService.findById(id);
	}

	@PostMapping("/diary")
	public Diary post(@RequestBody Diary diary) {
		log.info("getDatePresence = {} ",diary.getDatePresence());
		return diaryService.insert(diary);
	}

	@PutMapping("/diary/{id}")
	public Diary put(@RequestBody Diary diary, @PathVariable String id) {
		
		if(StringUtils.isEmpty(diary.getId()) ||
				!diary.getId().equals(id))
			throw new RuntimeException("Id on Diary is not matches!");

		return diaryService.update(diary);
	}

	@DeleteMapping("/diary/{id}")
	public void delete(@PathVariable String id) {
		diaryService.delete(id);
	}

	@GetMapping("/diary/{studentId}/student")
	public List<Diary> findByStudent(@PathVariable String studentId) {
		Student student = studentService.findById(studentId);

		return diaryService.findByStudent(student);
	}

	@GetMapping("/diary/{moduleId}/module")
	public List<Diary> findByModule(@PathVariable String moduleId) {
		Module module = moduleService.findById(moduleId);

		return diaryService.findByModule(module);
	}

	@GetMapping("/diary/{beginDate}/{endDate}")
	public List<Diary> findByDatePresenceBetween(
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable LocalDate beginDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@PathVariable LocalDate endDate){
		log.info("\ndata1={}\ndata2{}",beginDate,endDate);
		return diaryService.findByDatePresenceBetween(beginDate, endDate);
	}
}
