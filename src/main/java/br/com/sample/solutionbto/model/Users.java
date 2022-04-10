package br.com.sample.solutionbto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users extends  GenericEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NonNull
	@TextIndexed(weight = 2)
	public String firstName;

	@NonNull
	@TextIndexed
	public String lastName;

	@NonNull
	public String email;

	@NonNull
	public String password;
}
