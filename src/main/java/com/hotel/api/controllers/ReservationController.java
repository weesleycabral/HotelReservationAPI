package com.hotel.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.dtos.data.ReservationDataDTO;
import com.hotel.api.entities.Reservation;
import com.hotel.api.services.ReservationService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/reservation")
@AllArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;

  @GetMapping("/list")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Reservation> getAllReservations() {
    return reservationService.getAllReservations();
  }

  @PostMapping("/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createReservation(@RequestBody ReservationDataDTO reservationDTO) {
    reservationService.createReservation(reservationDTO);
  }

  @PostMapping("/update/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void updateReservation(@PathVariable("id") Long id, @Valid @RequestBody ReservationDataDTO rDataDTO) {
    reservationService.updateReservation(id, rDataDTO);
  }

  @PostMapping("/delete")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteAllReservations() {
    reservationService.deleteAllReservations();
  }

  @PostMapping("/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteReservation(@PathVariable("id") Long id) {
    reservationService.deleteReservationById(id);
  }

}
