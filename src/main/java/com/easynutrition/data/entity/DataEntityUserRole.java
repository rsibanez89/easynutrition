package com.easynutrition.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.easynutrition.data.type.DataTypeUserRole;

@Entity
@Table(name = "user_role")
public class DataEntityUserRole implements Serializable {
	private static final long serialVersionUID = -720854735618273426L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DataTypeUserRole name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataTypeUserRole getName() {
		return name;
	}

	public void setName(DataTypeUserRole name) {
		this.name = name;
	}

}

