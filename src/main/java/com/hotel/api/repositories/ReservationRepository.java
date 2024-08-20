package com.hotel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.api.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  Reservation findByRoomId(Long roomId);

  Reservation findByClientId(Long clientId);

}
