package com.easynutrition.entity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.easynutrition.dao.PatientDao;
import com.easynutrition.entity.Patient;
import com.easynutrition.entity.validator.qualifier.ValidatorQualifierPatient;

public class ValidatorPatient implements ConstraintValidator<ValidatorQualifierPatient, Patient> {
	@Autowired
	private PatientDao patientDao;
	
	@Override
	public void initialize(ValidatorQualifierPatient constraintAnnotation) {
	}

	@Override
	public boolean isValid(Patient patient, ConstraintValidatorContext context) {
		boolean res = true;
		
		if (patient != null) {
			context.disableDefaultConstraintViolation();
			
			// email unique
			if (patientDao.findByEmail(patient.getEmail()) != null) {
				context
					.buildConstraintViolationWithTemplate("{patient.validation.email.unique}")
					.addNode("email")
					.addConstraintViolation();
				res = false;
			}
		}
		
		return res;
	}

}
