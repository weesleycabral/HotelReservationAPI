package com.hotel.api.dtos;

import java.util.List;

import java.time.LocalDate;

import com.hotel.api.entities.Client;
import com.hotel.api.entities.Reservation;
import com.hotel.api.entities.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
  private Long id;
  private Room room;
  private Client client;
  private LocalDate checkIn;
  private LocalDate checkOut;

  public static Reservation toEntity(ReservationDTO dto) {
    return new Reservation(dto.getId(), dto.getRoom(), dto.getClient(), dto.getCheckIn(), dto.getCheckOut());
  }

  public static ReservationDTO toDTO(Reservation reservation) {
    return new ReservationDTO(reservation.getId(), reservation.getRoom(), reservation.getClient(),
        reservation.getCheckInDate(), reservation.getCheckOutDate());
  }

  public static List<ReservationDTO> toDTOs(List<Reservation> reservations) {
    return reservations.stream().map(ReservationDTO::toDTO).toList();
  }
}
