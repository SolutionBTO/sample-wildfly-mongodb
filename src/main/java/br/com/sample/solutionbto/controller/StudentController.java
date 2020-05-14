package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = {"","/"})
	public List<Student> getAll() {
		return studentService.findAll();
	}

	@GetMapping("/{id}")
	public Student getFindById(@PathVariable String id) {
		return studentService.findById(id);
	}

	@PostMapping
	public Student post(@RequestBody Student student) {
		return studentService.insert(student);
	}

	@PutMapping("/{id}")
	public Student put(@RequestBody Student student, @PathVariable String id) {
		
		if(StringUtils.isEmpty(student.getId()) ||
				!student.getId().equals(id))
			throw new RuntimeException("Id on Student is not matches!");
		
		return studentService.update(student);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		studentService.delete(id);
	}
}
