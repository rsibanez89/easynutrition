package com.easynutrition.data.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.entity.DataEntityPatient;
import com.easynutrition.data.validator.qualifier.DataValidatorQualifierPatient;

public class DataValidatorPatient implements ConstraintValidator<DataValidatorQualifierPatient, DataEntityPatient> {
	@Autowired
	private DataDaoPatient daoPatient;
	
	
	@Override
	public void initialize(DataValidatorQualifierPatient constraintAnnotation) {
	}

	@Override
	public boolean isValid(DataEntityPatient patient, ConstraintValidatorContext context) {
		boolean res = true;
		
		if (patient != null) {
//			context.disableDefaultConstraintViolation();
			
			// email unique
//			DataEntityPatient foundPatient = daoPatient.findByEmail(patient.getEmail());
//			if (foundPatient != null) {
//				context
//					.buildConstraintViolationWithTemplate("{patient.validation.email.unique}")
//					.addPropertyNode("email")
//					.addConstraintViolation();
//				res = false;
//			}
		}
		
		return res;
	}

}
