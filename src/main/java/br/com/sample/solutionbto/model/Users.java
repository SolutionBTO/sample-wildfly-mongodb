package br.com.sample.solutionbto.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users implements Serializable{

	private static final long serialVersionUID = -8643342433554304098L;
	
	@Id
	public String id;
	
	@NotNull
	public String name;
	
	@NotNull
	public String email;
	
	@NotNull
	public String password;

	public Users() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
