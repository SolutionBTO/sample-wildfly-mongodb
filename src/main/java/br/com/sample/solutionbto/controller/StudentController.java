package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "student")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public List<Student> getAll() {
		return studentService.findAll();
	}

	@GetMapping("/student/{id}")
	public Student getFindById(@PathVariable String id) {
		return studentService.findById(id);
	}

	@PostMapping("/student")
	public Student post(@RequestBody Student student) {
		return studentService.insert(student);
	}

	@PutMapping("/student/{id}")
	public Student put(@RequestBody Student student, @PathVariable String id) {
		
		if(StringUtils.isEmpty(student.getId()) ||
				!student.getId().equals(id))
			throw new RuntimeException("Id on Student is not matches!");
		
		return studentService.update(student);
	}

	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable String id) {
		studentService.delete(id);
	}
}
