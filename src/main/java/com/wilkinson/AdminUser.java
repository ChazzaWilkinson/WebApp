package com.wilkinson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "password")
@Entity
public class AdminUser {

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	private @Id @GeneratedValue Long id;

	private String name;

	private @JsonIgnore String password;

	private String[] roles;

	public String setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
		return this.password;
	}

	protected AdminUser() {}

	public AdminUser(String name, String password, String...roles) {

		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.setPassword(password);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String[] getRoles() {
		// TODO Auto-generated method stub
		return roles;
	}

	public void setName(String name2) {
		this.name = name2;
		
	}

	public void setRoles(String[] strings) {
		this.roles = strings;
		
	}


}