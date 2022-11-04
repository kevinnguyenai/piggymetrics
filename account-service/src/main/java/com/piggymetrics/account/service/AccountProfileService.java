package com.piggymetrics.account.service;

import com.piggymetrics.account.domain.AccountProfile;

public interface AccountProfileService  {
    
    /**
     * define an Account Profile Object
     * 
     * @param firstname
     * @param lastname
     * @param email
     * @param countryname
     * @param postalcode
     * @param phonenumber
     * @return AccountProfile
     */
    AccountProfile profileDefine(String firstname, String lastname, String email, String countryname, Long postalcode, String phonenumber);


    /**
     * get AccountProfile from Account
     * 
     * @param name
     * @return AccountProfile
     */
    AccountProfile getProfile(String name);
}
