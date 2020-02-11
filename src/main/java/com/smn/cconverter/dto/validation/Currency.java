package com.smn.cconverter.dto.validation;

import com.smn.cconverter.dto.validation.impl.CurrencyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrencyValidator.class)
public @interface Currency {

    String message() default "Invalid Currency";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
