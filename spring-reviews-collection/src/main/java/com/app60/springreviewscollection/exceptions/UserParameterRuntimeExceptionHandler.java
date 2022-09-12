package com.app60.springreviewscollection.exceptions;

import com.app60.springreviewscollection.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserParameterRuntimeExceptionHandler {

    @ExceptionHandler(value = {UserParameterRuntimeException.class})
    public ResponseEntity<Response> handleUserParametersRuntimeException(
            UserParameterRuntimeException e){

        HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

        Response errorResponse = Response.builder()
                .message(e.getMessage())
                .throwable(e)
                .status(BAD_REQUEST)
                .statusCode(BAD_REQUEST.value())
                .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();

        return new ResponseEntity<>(errorResponse,BAD_REQUEST);
    }
}
