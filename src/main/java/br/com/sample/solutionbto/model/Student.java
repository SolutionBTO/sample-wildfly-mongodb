package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student extends GenericEntity {

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
