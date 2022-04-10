package br.com.sample.solutionbto.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Module extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private BigDecimal value;
}
