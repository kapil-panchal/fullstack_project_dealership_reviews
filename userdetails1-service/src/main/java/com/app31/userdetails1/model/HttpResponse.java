package com.app31.userdetails1.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HttpResponse {

	private int HttpStatusCode;
	private HttpStatus httpStatus;
	private String reason;
	private String message;
}