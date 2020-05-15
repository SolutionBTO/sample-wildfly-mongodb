package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Student extends GenericEntity {

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
