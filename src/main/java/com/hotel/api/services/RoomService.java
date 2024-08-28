package com.hotel.api.services;

import java.util.List;

import com.hotel.api.dtos.data.RoomDataDTO;
import com.hotel.api.entities.Room;

public interface RoomService {
  public Room createRoom(RoomDataDTO room);

  public Room getRoom(Long id);

  public List<Room> getAllRooms();

  public void updateRoom(Long id, RoomDataDTO room);

  public void deleteAllRooms();

  public void deleteRoomById(Long id);
}
