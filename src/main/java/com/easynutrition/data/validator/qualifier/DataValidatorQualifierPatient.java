package com.easynutrition.data.validator.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Qualifier;

import com.easynutrition.data.validator.DataValidatorPatient;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = DataValidatorPatient.class)
public @interface DataValidatorQualifierPatient {
	String message() default "<empty>"; 

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}