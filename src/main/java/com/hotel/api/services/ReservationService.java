package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.Reservation;

public interface ReservationService {
  public Reservation createReservation(Reservation reservation);

  public Reservation getReservation(Long id);

  public List<Reservation> getAllReservations();

  public Reservation updateReservation(Long id, Reservation reservation);

  public void deleteReservation(Long id);
}
