package com.hotel.api.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.Room;
import com.hotel.api.repositories.RoomRepository;
import com.hotel.api.services.RoomService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public Room createRoom(Room room) {
    return roomRepository.save(room);
  }

  @Override
  public Room getRoom(Long id) {
    Room room;
    room = roomRepository.findById(id).get();
    return room;
  }

  @Override
  public List<Room> getAllRooms() {
    List<Room> rooms;
    rooms = roomRepository.findAll();
    return rooms;
  }

  @Override
  public Room updateRoom(Long id, Room room) {
    Room updatedRoom;
    updatedRoom = roomRepository.save(room);
    return updatedRoom;
  }

  @Override
  public void deleteRoom(Long id) {
    roomRepository.deleteById(id);
  }

}
