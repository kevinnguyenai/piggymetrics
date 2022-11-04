package com.piggymetrics.account.service;

import com.piggymetrics.account.domain.AccountProfile;
import com.piggymetrics.account.repository.AccountRepository;
import com.piggymetrics.account.domain.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AccountProfileServiceImpl  implements AccountProfileService {
    private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository repository;
    
	/**
	 * {@inheritDoc}
	 */
    @Override
    public AccountProfile profileDefine(String firstname, String lastname, String email, String countryname, Long postalcode, String phonenumber) {
		AccountProfile profile = new AccountProfile();
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setEmail(email);
		profile.setCountryname(countryname);
		profile.setPostalcode(postalcode);
		profile.setPhonenumber(phonenumber);

		return profile;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountProfile getProfile(String name){
		Account account = repository.findByName(name);
		Assert.notNull(account, "can't find account with name " + name);

		return account.getAccountprofile();
	}
}
