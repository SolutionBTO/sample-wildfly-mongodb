package br.com.sample.solutionbto.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Users extends  GenericEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NonNull
	@TextIndexed(weight = 2)
	private String firstName;

	@NonNull
	@TextIndexed
	private String lastName;

	@NonNull
	private String email;

	@NonNull
	private String password;
}
