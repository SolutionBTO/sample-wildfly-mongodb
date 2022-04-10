package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @DBRef
    private Student student;

    @DBRef
    private Module module;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePresence;

    private boolean presence;
}
