package com.piggymetrics.account.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public void initialize(PhoneNumberConstraint phoneNumber) {}

    @Override
    public boolean isValid(String phoneField, ConstraintValidatorContext context) {
        PhoneNumber number;
        final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            number = phoneUtil.parse(phoneField, "");
            boolean isNumberValid = phoneUtil.isValidNumber(number);
            return isNumberValid;
        } catch (NumberParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
}
