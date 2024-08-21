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

import com.hotel.api.dtos.data.RoomDataDTO;
import com.hotel.api.entities.Room;
import com.hotel.api.services.RoomService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/room")
@AllArgsConstructor
public class RoomController {

  private final RoomService roomService;

  @GetMapping("/list")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Room> getAllRooms() {
    return roomService.getAllRooms();
  }

  @PostMapping("/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createRoom(@RequestBody RoomDataDTO roomDTO) {
    roomService.createRoom(roomDTO);
  }

  @PostMapping("/update/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void updateRoom(@PathVariable("id") Long id, @Valid @RequestBody RoomDataDTO rDataDTO) {
    roomService.updateRoom(id, rDataDTO);
  }

  @PostMapping("/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteRoom(@PathVariable("id") Long id) {
    roomService.deleteRoom(id);
  }

}
