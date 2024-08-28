package com.hotel.api.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoomAlreadyExistsException extends RuntimeException {

  private final HttpStatus status = HttpStatus.BAD_REQUEST;

  public RoomAlreadyExistsException() {
    super("Room already exists");
  }
}
