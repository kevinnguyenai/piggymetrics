package com.piggymetrics.account.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {CountryCodeValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryCodeConstraint {
    String message() default "Invalid country name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
