package com.hotel.api.dtos.data;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotel.api.entities.Reservation;
import com.hotel.api.entities.Room;

public record ReservationDataDTO(Room room,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate checkIn,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") LocalDate checkOut) {

  public Reservation toEntity() {
    Reservation reservation = new Reservation(room, checkIn, checkOut);
    reservation.setRoom(this.room);
    return reservation;
  }

}
