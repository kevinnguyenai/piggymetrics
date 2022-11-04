package com.piggymetrics.account.service;

import com.piggymetrics.account.domain.DatabaseSequence;

public interface SequenceGenerator {

    int create(DatabaseSequence dseq);
    
}
