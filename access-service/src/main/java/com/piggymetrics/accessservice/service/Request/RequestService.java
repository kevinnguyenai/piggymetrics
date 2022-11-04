package com.piggymetrics.accessservice.service.Request;

import java.util.List;
import java.util.Optional;

import com.piggymetrics.accessservice.domain.Logger.Request;
import com.piggymetrics.accessservice.service.Request.exception.RequestDuplicate;
import com.piggymetrics.accessservice.service.Request.exception.RequestNotFound;

public interface RequestService {
    Optional<Request> getById(String id);

    List<Request> getAll();

    List<Request> findByFrom(String from);

    Request create(Request request) throws RequestDuplicate;

    void delete(String id);

    Request update(String id, Request request) throws RequestNotFound;

}
