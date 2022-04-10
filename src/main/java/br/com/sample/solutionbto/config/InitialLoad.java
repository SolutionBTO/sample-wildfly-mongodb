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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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
        var random = new Random();

        if (students.isEmpty()) {
            for (int x=1; x <= 25; x++)
                this.createStudent( Student.builder()
                                            .name("Student_"+x)
                                            .birthDay(LocalDate.of(1983, random.nextInt(11)+1,x))
                                            .enrollmentDate(LocalDate.now())
                                            .city( x%2==0 ? "SP":"PE")
                                    .build());
        }

        List<Module> modules = moduleRepository.findAll();

        if (modules.isEmpty()) {
            this.createModule( Module.builder()
                                        .name("Modulo 1")
                                        .value(BigDecimal.valueOf(250))
                                .build());
            this.createModule( Module.builder()
                                        .name("Modulo 2")
                                        .value(BigDecimal.valueOf(250))
                                .build());
        }
    }

    private void createStudent(Student student) {
        student.setCreated(LocalDateTime.now());
        studentRepository.save(student);
    }

    private void createModule(Module module) {
        module.setCreated(LocalDateTime.now());
        moduleRepository.save(module);
    }
}
