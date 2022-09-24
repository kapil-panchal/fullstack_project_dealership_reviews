package com.app60.springreviewscollection.exception;

import com.app60.springreviewscollection.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserParametersExceptionHandler {

    @ExceptionHandler(value = {UserParametersException.class})
    public ResponseEntity<Response> handleUserParameterException(UserParametersException e){

        HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

        Response errorResponse = Response.builder()
                .message(e.getMessage())
                .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                .throwable(e)
                .statusCode(BAD_REQUEST.value())
                .status(BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }
}
