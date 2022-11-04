package com.piggymetrics.accessservice.repo;

import com.piggymetrics.accessservice.domain.metasploit.Token;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<Token, String> {}
