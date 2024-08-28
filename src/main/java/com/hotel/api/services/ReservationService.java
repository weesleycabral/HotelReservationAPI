package com.hotel.api.services;

import java.util.List;
import java.time.LocalDate;

import com.hotel.api.dtos.data.ReservationDataDTO;
import com.hotel.api.entities.Reservation;

public interface ReservationService {
  public boolean isRoomAvailable(Long roomId, LocalDate startDate, LocalDate endDate);

  public void createReservation(ReservationDataDTO reservation);

  public Reservation getReservation(Long id);

  public List<Reservation> getAllReservations();

  public void updateReservation(Long id, ReservationDataDTO reservation);

  public void deleteAllReservations();

  public void deleteReservationById(Long id);

  public void sentConfirmationEmail(Reservation reservation);
}
