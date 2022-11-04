package com.piggymetrics.accessservice.service.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.piggymetrics.accessservice.domain.Logger.Request;
import com.piggymetrics.accessservice.repo.RequestRepository;
import com.piggymetrics.accessservice.service.Request.exception.RequestDuplicate;
import com.piggymetrics.accessservice.service.Request.exception.RequestNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepo;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public void DefaultRequestService(RequestRepository requestRepo, ElasticsearchTemplate elasticsearchTemplate) {
        this.requestRepo = requestRepo;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public Optional<Request> getById(String id) {
        return requestRepo.findById(id);
    }

    @Override
    public List<Request> getAll() {
        List<Request> reqs = new ArrayList<>();
        requestRepo.findAll().forEach(y -> reqs.add((Request) y));
        return reqs;
    }

    @Override
    public List<Request> findByFrom(String from) {
        return requestRepo.findByFrom(from);
    }

    @Override
    public Request create(Request request) throws RequestDuplicate {
        if (getById(request.getId()).isEmpty()) {
            return requestRepo.save(request);
        }
        throw new RequestDuplicate(String.format("The provided id: %s already exist. use update instead", request.getId()));
    }

    @Override
    public void delete(String id) {
        requestRepo.deleteById(id);
        
    }

    @Override
    public Request update(String id, Request request) throws RequestNotFound {
        Request old = requestRepo.findById(id).orElseThrow(() -> new RequestNotFound("There is not Request associated with given id"));
        old.setFrom(request.getFrom());
        old.setPath(request.getPath());
        old.setPublicDateTime(request.getPublicDateTime());
        return requestRepo.save(old);
    }
}
