package com.easynutrition.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.easynutrition.api.rest.serializer.ApiRestSerializerCalendar;
import com.easynutrition.entity.type.TypeGender;
import com.easynutrition.entity.validator.qualifier.ValidatorQualifierPatient;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "patient")
@ValidatorQualifierPatient
public class Patient implements Serializable {
	private static final long serialVersionUID = -6894117922254023362L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z]*", message = "{patient.validation.name}")
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z]*", message = "{patient.validation.name}")
	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private TypeGender gender;

	@JsonSerialize(using = ApiRestSerializerCalendar.class)
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar birthday;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Size(min = 10, max = 12)
	@Column(name = "phone_number")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public TypeGender getGender() {
		return gender;
	}

	public void setGender(TypeGender gender) {
		this.gender = gender;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
