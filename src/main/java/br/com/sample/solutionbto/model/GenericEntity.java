package br.com.sample.solutionbto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@Document
public class GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @CreatedDate
    private LocalDateTime created;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @LastModifiedDate
    private LocalDateTime modified;

    @TextScore
    private Float score;
}
