package com.hotel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.api.entities.Room;
import com.hotel.api.enums.RoomType;

public interface RoomRepository extends JpaRepository<Room, Long> {
  Room findByRoomNumber(String roomNumber);

  Room findByRoomType(RoomType roomType);

}
