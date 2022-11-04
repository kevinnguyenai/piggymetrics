package com.piggymetrics.accessservice.controller.Request.exception;

import com.piggymetrics.accessservice.service.Request.exception.RequestDuplicate;
import com.piggymetrics.accessservice.service.Request.exception.RequestNotFound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RequestControllerExceptionHandler {

    @ExceptionHandler(value = {RequestNotFound.class, RequestDuplicate.class})
    public ResponseEntity<Body> doHandleRequestException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Body(ex.getMessage()));
    }

    public static class Body {
        private String message;

        public Body(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    
    
}
