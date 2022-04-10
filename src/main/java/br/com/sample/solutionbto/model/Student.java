package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDay;
}
