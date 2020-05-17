package br.com.sample.solutionbto.config;

import br.com.sample.solutionbto.model.Module;
import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.repository.DiaryRepository;
import br.com.sample.solutionbto.repository.ModuleRepository;
import br.com.sample.solutionbto.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class InitialLoad implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Student> students = studentRepository.findAll();

        if (students.isEmpty()) {
            this.createStudent("Nataniel", "1991-04-10");
            this.createStudent("Fulano", "1992-04-10");
            this.createStudent("Ciclano", "1983-04-10");
            this.createStudent("João", "1989-04-10");
            this.createStudent("Maria", "1985-04-10");
        }

        List<Module> modules = moduleRepository.findAll();

        if (modules.isEmpty()) {
            this.createModule("Modulo 1");
            this.createModule("Modulo 2");
        }
    }

    private void createStudent(String name, String birthDay) {
        Student student = new Student();
        student.setName(name);

        try {
            student.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse(birthDay));
        } catch (ParseException pEx){
            throw new RuntimeException(pEx);
        }

        studentRepository.save(student);
    }

    private void createModule(String name) {
        Module module = new Module();
        module.setName(name);
        moduleRepository.save(module);
    }
}
