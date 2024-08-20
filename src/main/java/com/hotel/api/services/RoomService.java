package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.Room;

public interface RoomService {
  public Room createRoom(Room room);

  public Room getRoom(Long id);

  public List<Room> getAllRooms();

  public Room updateRoom(Long id, Room room);

  public void deleteRoom(Long id);
}
