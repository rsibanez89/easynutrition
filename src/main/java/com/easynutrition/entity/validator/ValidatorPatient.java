package com.easynutrition.entity.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.easynutrition.dao.DaoPatient;
import com.easynutrition.entity.Patient;
import com.easynutrition.entity.validator.qualifier.ValidatorQualifierPatient;

public class ValidatorPatient implements ConstraintValidator<ValidatorQualifierPatient, Patient> {
	@Autowired
	private DaoPatient daoPatient;
	
	
	@Override
	public void initialize(ValidatorQualifierPatient constraintAnnotation) {
	}

	@Override
	public boolean isValid(Patient patient, ConstraintValidatorContext context) {
		boolean res = true;
		
		if (patient != null) {
			context.disableDefaultConstraintViolation();
			
			// email unique
			Patient foundPatient = daoPatient.findByEmail(patient.getEmail());
			if (foundPatient != null) {
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
