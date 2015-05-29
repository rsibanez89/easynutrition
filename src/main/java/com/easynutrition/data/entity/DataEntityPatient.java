package com.easynutrition.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.easynutrition.api.rest.view.ApiRestView.ApiRestViewPatientOnly;
import com.easynutrition.data.type.DataTypeGender;
import com.easynutrition.data.validator.qualifier.DataValidatorQualifierPatient;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name = "patient")
@Table(name = "patient")
@DataValidatorQualifierPatient
public class DataEntityPatient implements Serializable {
	private static final long serialVersionUID = -6894117922254023362L;

	@Id
	@GeneratedValue
	@JsonView(ApiRestViewPatientOnly.class)
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z]*", message = "{patient.validation.name}")
	@Column(name = "first_name")
	@JsonView(ApiRestViewPatientOnly.class)
	private String firstName;

	@NotNull
	@Size(min = 1, max = 50)
	@Pattern(regexp = "[A-Za-z]*", message = "{patient.validation.name}")
	@Column(name = "last_name")
	@JsonView(ApiRestViewPatientOnly.class)
	private String lastName;

	@Enumerated(EnumType.STRING)
	@JsonView(ApiRestViewPatientOnly.class)
	private DataTypeGender gender;

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonView(ApiRestViewPatientOnly.class)
	private Calendar birthday;

	@Email
	@JsonView(ApiRestViewPatientOnly.class)
	private String email;

	@NotNull
	@Size(min = 10, max = 12)
	@Column(name = "phone_number")
	@JsonView(ApiRestViewPatientOnly.class)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<DataEntityEvaluation> evaluations = new ArrayList<>();

	
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

	public DataTypeGender getGender() {
		return gender;
	}

	public void setGender(DataTypeGender gender) {
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

	public List<DataEntityEvaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<DataEntityEvaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
}
