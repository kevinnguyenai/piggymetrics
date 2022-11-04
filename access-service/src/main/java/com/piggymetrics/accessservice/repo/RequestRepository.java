package com.piggymetrics.accessservice.repo;

import java.util.List;
import java.util.Optional;

import com.piggymetrics.accessservice.domain.Logger.Request;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends ElasticsearchRepository<Request, String> {
    List<Request> findByFrom(String from);
    
    Optional<Request> findById(String id);
}
