package com.hotel.api.services.Impl;

import java.util.List;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.hotel.api.dtos.EmailDTO;
import com.hotel.api.entities.Reservation;
import com.hotel.api.exceptions.RoomNotAvailableException;
import com.hotel.api.repositories.ReservationRepository;
import com.hotel.api.services.ReservationService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationServiceImpl implements ReservationService {

  private ReservationRepository reservationRepository;

  private EmailServiceImpl emailService;

  @Override
  public boolean isRoomAvailable(Long roomId, LocalDate startDate, LocalDate endDate) {
    Reservation reservation = reservationRepository.findByRoomId(roomId);
    if (startDate.isBefore(reservation.getCheckOutDate()) && endDate.isAfter(reservation.getCheckInDate())) {
      return false;
    }
    return true;
  }

  @Override
  public Reservation createReservation(Reservation reservation) {
    if (isRoomAvailable(reservation.getRoom().getId(), reservation.getCheckInDate(), reservation.getCheckOutDate())) {
      return reservationRepository.save(reservation);
    } else {
      throw new RoomNotAvailableException();
    }
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

  @Override
  public void sentConfirmationEmail(Reservation reservation) {
    String to = reservation.getClient().getEmail();
    String subject = "Confirmação de Reserva";
    String text = "Sua reserva foi confirmada. Detalhes: " + reservation.toString();
    EmailDTO emailDTO = new EmailDTO(to, subject, text);
    emailService.sendMail(emailDTO);
  }

}
