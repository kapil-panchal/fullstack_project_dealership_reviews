package com.app60.springreviewscollection.exception;

public class UserParametersException extends RuntimeException{
    public UserParametersException(String message) {
        super(message);
    }

    public UserParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}
