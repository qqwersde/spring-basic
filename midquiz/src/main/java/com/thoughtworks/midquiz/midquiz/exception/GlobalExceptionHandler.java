package com.thoughtworks.midquiz.midquiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResult> handle(NotFoundException ex) {
    ErrorResult errorResult = new ErrorResult(LocalDateTime.now().toString(),404,"Not Found",ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
  }
}
