package com.app60.springreviewscollection.exceptions;

public class UserParameterRuntimeException extends RuntimeException{
    public UserParameterRuntimeException(String message) {
        super(message);
    }

    public UserParameterRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
