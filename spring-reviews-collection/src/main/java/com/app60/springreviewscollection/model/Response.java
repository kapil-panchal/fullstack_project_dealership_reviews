package com.app60.springreviewscollection.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Response {
    @Builder.Default
    protected ZonedDateTime timeStamp = ZonedDateTime.now(ZoneId.of("Z"));
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;
    protected Throwable throwable;
}