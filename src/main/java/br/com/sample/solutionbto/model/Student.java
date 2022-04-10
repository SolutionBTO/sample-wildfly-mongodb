package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Student extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String city;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;

    /**
     * data matricula
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate enrollmentDate;
}
