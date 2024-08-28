package com.hotel.api.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.dtos.data.RoomDataDTO;
import com.hotel.api.entities.Room;
import com.hotel.api.exceptions.RoomAlreadyExistsException;
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
  public Room createRoom(RoomDataDTO roomDataDTO) {
    Room existingRoom = roomRepository.findByRoomNumber(roomDataDTO.roomNumber());
    if (existingRoom != null) {
      throw new RoomAlreadyExistsException();
    }
    return roomRepository.save(roomDataDTO.toEntity());
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
  public void updateRoom(Long id, RoomDataDTO roomDTO) {
    Room updatedClient = roomDTO.toEntity();
    updatedClient.setId(id);
    roomRepository.save(updatedClient);
  }

  @Override
  public void deleteAllRooms() {
    roomRepository.deleteAll();
  }

  @Override
  public void deleteRoomById(Long id) {
    roomRepository.deleteById(id);
  }

}
