package br.com.sample.solutionbto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
}
