package br.com.sample.solutionbto.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

import java.io.Serializable;

public class Users extends  GenericEntity implements Serializable{

	private static final long serialVersionUID = -8643342433554304098L;

	@TextIndexed
	public String firstName;

	@TextIndexed
	public String lastName;

	public String email;
	
	public String password;

	public Users() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
