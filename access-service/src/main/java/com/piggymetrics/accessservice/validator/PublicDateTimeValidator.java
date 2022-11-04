package com.piggymetrics.accessservice.validator;

import java.time.Year;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.piggymetrics.accessservice.metadata.PublicDateTime;

public class PublicDateTimeValidator implements ConstraintValidator<PublicDateTime, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return !Year.of(value).isAfter(Year.now());
    }
}
