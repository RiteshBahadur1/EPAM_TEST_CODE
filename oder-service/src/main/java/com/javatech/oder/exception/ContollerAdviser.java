package com.javatech.oder.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ContollerAdviser extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderNotFound.class)
	public ResponseEntity<Object> handleOrderNotFound(OrderNotFound ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Order not found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
