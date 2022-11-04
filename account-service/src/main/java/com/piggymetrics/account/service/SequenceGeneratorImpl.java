package com.piggymetrics.account.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.piggymetrics.account.domain.DatabaseSequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;



@Service
public class SequenceGeneratorImpl {
    
    private final Logger log = LoggerFactory.getLogger(getClass());
    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorImpl(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    public int create(DatabaseSequence sreq) {
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(sreq)), new Update().inc("seq", 1), options().returnNew(true).upsert(true),
        DatabaseSequence.class);

        log.info("sequence number of id : {} was updated", sreq);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
