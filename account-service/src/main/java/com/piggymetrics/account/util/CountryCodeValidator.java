package com.piggymetrics.account.util;
 
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CountryCodeValidator implements ConstraintValidator<CountryCodeConstraint, String> {
    
    @Override
    public void initialize(CountryCodeConstraint contactNumber) {}

    @Override
    public boolean isValid(String countryField, ConstraintValidatorContext context) {
        CountryCode code = new CountryCode();
        return countryField != null && code.getCode(countryField) != null;
    }

}