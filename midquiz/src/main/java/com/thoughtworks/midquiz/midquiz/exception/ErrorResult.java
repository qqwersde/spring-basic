package com.thoughtworks.midquiz.midquiz.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

  private String imestamp;
  private Integer status;
  private String error;
  private String message;
}
