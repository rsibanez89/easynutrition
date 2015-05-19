package com.easynutrition.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.easynutrition.entity.type.TypeUserRole;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = -720854735618273426L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TypeUserRole name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeUserRole getName() {
		return name;
	}

	public void setName(TypeUserRole name) {
		this.name = name;
	}

}

