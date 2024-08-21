package com.hotel.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hotel.api.exceptions.ErrorMessage;
import com.hotel.api.exceptions.RoomNotAvailableException;

@ControllerAdvice
public class CustomExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ RoomNotAvailableException.class })
  public ResponseEntity<ErrorMessage> handleRoomNotAvailableException(RoomNotAvailableException exception) {
    return ResponseEntity.status(exception.getStatus())
        .body(new ErrorMessage(exception.getMessage(), exception.getStatus()));
  }
}
