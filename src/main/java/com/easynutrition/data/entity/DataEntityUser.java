package com.easynutrition.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
public class DataEntityUser implements Serializable {
	private static final long serialVersionUID = -720854735618273426L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String password;
	
	private boolean enabled;

	@ManyToOne
	private DataEntityUserRole role;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public DataEntityUserRole getRole() {
		return role;
	}

	public void setRole(DataEntityUserRole role) {
		this.role = role;
	}
	
}
