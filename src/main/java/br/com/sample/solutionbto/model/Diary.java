package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Diary extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @DBRef
    private Student student;

    @DBRef
    private Module module;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate datePresence;

    private boolean presence;
}
