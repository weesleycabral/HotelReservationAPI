package com.hotel.api.services.Impl;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.dtos.EmailDTO;
import com.hotel.api.dtos.data.ReservationDataDTO;
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

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private EmailServiceImpl emailService;

  @Override
  public boolean isRoomAvailable(Long roomId, LocalDate startDate, LocalDate endDate) {
    List<Reservation> reservations = reservationRepository.findByRoomId(roomId);
    for (Reservation reservation : reservations) {
      if (startDate.isBefore(reservation.getCheckOutDate()) && endDate.isAfter(reservation.getCheckInDate())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void createReservation(ReservationDataDTO reservation) {
    if (isRoomAvailable(reservation.room().getId(), reservation.checkIn(), reservation.checkOut())) {
      Reservation reservationToEntity = reservation.toEntity();
      reservationRepository.save(reservationToEntity);
      sentConfirmationEmail(reservationToEntity);
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
  public void updateReservation(Long id, ReservationDataDTO reservation) {
    Reservation updatedReservation = reservation.toEntity();
    updatedReservation.setId(id);
    reservationRepository.save(updatedReservation);
  }

  @Override
  public void deleteAllReservations() {
    reservationRepository.deleteAll();
  }

  @Override
  public void deleteReservationById(Long id) {
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
