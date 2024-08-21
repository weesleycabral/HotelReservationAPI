package com.hotel.api.dtos.data;

import java.time.LocalDate;

import com.hotel.api.entities.Reservation;

public record ReservationDataDTO(LocalDate checkIn, LocalDate checkOut) {

  public Reservation toEntity() {
    return new Reservation(checkIn, checkOut);
  }

}
