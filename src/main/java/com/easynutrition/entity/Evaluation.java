package com.easynutrition.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.easynutrition.api.rest.serializer.ApiRestSerializerCalendar;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = -1757573848016133050L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    private Patient patient;
	
	@JsonSerialize(using = ApiRestSerializerCalendar.class)
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar date;
	
	@NotNull
	private double weight;
	
	@NotNull
	private double height;
	
	@Column(name = "waist_circumference")
	private double waistCircumference;
	
	@Column(name = "hip_circumference")
	private double hipCircumference;
	
	private String observation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWaistCircumference() {
		return waistCircumference;
	}

	public void setWaistCircumference(double waistCircumference) {
		this.waistCircumference = waistCircumference;
	}

	public double getHipCircumference() {
		return hipCircumference;
	}

	public void setHipCircumference(double hipCircumference) {
		this.hipCircumference = hipCircumference;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
