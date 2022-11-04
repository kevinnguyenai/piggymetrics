package com.piggymetrics.accessservice.metadata;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.piggymetrics.accessservice.validator.PublicDateTimeValidator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RUNTIME)
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})
@Constraint(validatedBy = PublicDateTimeValidator.class)
public @interface PublicDateTime {
    String message() default "Public datetime cannot be future time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
