package com.hotel.api.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.Reservation;
import com.hotel.api.repositories.ReservationRepository;
import com.hotel.api.services.ReservationService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  @Override
  public Reservation createReservation(Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  @Override
  public Reservation getReservation(Long id) {
    Reservation reservation;
    reservation = reservationRepository.findById(id).get();
    return reservation;
  }

  @Override
  public List<Reservation> getAllReservations() {
    List<Reservation> reservations;
    reservations = reservationRepository.findAll();
    return reservations;
  }

  @Override
  public Reservation updateReservation(Long id, Reservation reservation) {
    Reservation updatedReservation;
    updatedReservation = reservationRepository.save(reservation);
    return updatedReservation;
  }

  @Override
  public void deleteReservation(Long id) {
    reservationRepository.deleteById(id);
  }

}
