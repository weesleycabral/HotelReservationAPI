package com.hotel.api.dtos.data;

import com.hotel.api.entities.Room;
import com.hotel.api.enums.RoomType;

public record RoomDataDTO(String roomNumber, RoomType roomType) {

  public Room toEntity() {
    return new Room(roomNumber, roomType);
  }

}
