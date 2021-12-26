package com.thoughtworks.midquiz.midquiz.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResult> handle(BaseException ex) {
    ErrorResult errorResult = new ErrorResult(LocalDateTime.now().toString(), ex.getMessage());
    return ResponseEntity.status(ex.getStatus()).body(errorResult);
  }


}
