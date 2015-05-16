package com.easynutrition.entity.validator.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Qualifier;

import com.easynutrition.entity.validator.ValidatorPatient;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = ValidatorPatient.class)
public @interface ValidatorQualifierPatient {
	String message() default "<empty>"; 

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}