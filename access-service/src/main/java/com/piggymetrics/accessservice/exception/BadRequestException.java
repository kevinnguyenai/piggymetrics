package com.piggymetrics.accessservice.exception;


/**
 * @author Kevin
 */
public class BadRequestException extends Exception {

    private static final long serialVersionUID = -1L;

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "BadRequestException: "+getMessage();
    }

}
