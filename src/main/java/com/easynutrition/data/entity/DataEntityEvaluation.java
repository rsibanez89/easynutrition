package com.easynutrition.data.entity;

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
import com.easynutrition.api.rest.view.ApiRestView.ApiRestViewEvaluationOnly;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "evaluation")
@Table(name = "evaluation")
public class DataEntityEvaluation implements Serializable {
	private static final long serialVersionUID = -1757573848016133050L;
	
	@Id
	@GeneratedValue
	@JsonView(ApiRestViewEvaluationOnly.class)
	private Long id;
	
	@ManyToOne
    private DataEntityPatient patient;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonSerialize(using = ApiRestSerializerCalendar.class)
	@JsonView(ApiRestViewEvaluationOnly.class)
    private Calendar date;
	
	@NotNull
	@JsonView(ApiRestViewEvaluationOnly.class)
	private double weight;
	
	@NotNull
	@JsonView(ApiRestViewEvaluationOnly.class)
	private double height;
	
	@Column(name = "waist_circumference")
	@JsonView(ApiRestViewEvaluationOnly.class)
	private Double waistCircumference;
	
	@Column(name = "hip_circumference")
	@JsonView(ApiRestViewEvaluationOnly.class)
	private Double hipCircumference;
	
	@JsonView(ApiRestViewEvaluationOnly.class)
	private String observation;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataEntityPatient getPatient() {
		return patient;
	}

	public void setPatient(DataEntityPatient patient) {
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

	public Double getWaistCircumference() {
		return waistCircumference;
	}

	public void setWaistCircumference(Double waistCircumference) {
		this.waistCircumference = waistCircumference;
	}

	public Double getHipCircumference() {
		return hipCircumference;
	}

	public void setHipCircumference(Double hipCircumference) {
		this.hipCircumference = hipCircumference;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
