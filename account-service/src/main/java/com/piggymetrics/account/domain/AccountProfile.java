package com.piggymetrics.account.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import com.piggymetrics.account.util.CountryCodeConstraint;
import com.piggymetrics.account.util.PhoneNumberConstraint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Digits;



@Document(collection = "accounts_profile")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountProfile {
    
    @Length(min = 1, max = 20)
    private String firstname;

    @Length(min = 1, max = 20)
    private String lastname;

    @Email(message = "Email should be valid")
    private String email;

    @CountryCodeConstraint
    private String countryname;


    @Digits(fraction = 0, integer = 5)
    private Long postalcode;

    @PhoneNumberConstraint
    private String phonenumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(long code) {
        this.postalcode = code;
    }

    public String getCountryName() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
