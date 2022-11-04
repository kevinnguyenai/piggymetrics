package com.piggymetrics.accessservice.controller.Request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.piggymetrics.accessservice.domain.Logger.Request;
import com.piggymetrics.accessservice.metadata.PublicDateTime;
import com.piggymetrics.accessservice.service.Request.RequestService;
import com.piggymetrics.accessservice.service.Request.exception.RequestDuplicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import brave.internal.Nullable;

@RestController
@RequestMapping("/logger/request")
public class RequestController {
    @Autowired
    RequestService reqSvc;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Request> getAllRequests() {
        return reqSvc.getAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Request createRequest(@Valid @RequestBody RequestDto req) throws RequestDuplicate {
        return reqSvc.create(RequestDto.transform(req));
    }


    final static class RequestDto {
        @NotBlank
        private String id;

        @Nullable
        private String from;

        @NotBlank
        private String path;

        @Positive
        @PublicDateTime
        private Integer publicDateTime;


        public static Request transform(RequestDto requestDto) {
            Request request = new Request();
            request.setFrom(requestDto.from);
            request.setPath(requestDto.path);
            request.setPublicDateTime(requestDto.publicDateTime);
            return request;
        }

        public String getPath() {
            return this.path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getPublicDateTime() {
            return this.publicDateTime;
        }

        public void setPublicDateTime(Integer d) {
            this.publicDateTime = d;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

    }


}
