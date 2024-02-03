package com.banking.onlineBanking.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "user")

@Builder(toBuilder = true, builderMethodName = "User")
public class Users {
	
	@Id
	@SequenceGenerator(name= "users_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_sequence")
	
	Long id;
	String password;
	String Name;
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return Name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + ", Name=" + Name + "]";
	}
	
	
	}