package com.hotel.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.api.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  List<Reservation> findByRoomId(Long roomId);

  Reservation findByClientId(Long clientId);

}
