package com.hotel.api.dtos;

import java.util.List;

import com.hotel.api.entities.Room;
import com.hotel.api.enums.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
  private Long id;
  private String roomNumber;
  private RoomType roomType;
  private boolean isAvailable;

  public static Room toEntity(RoomDTO dto) {
    return new Room(dto.getId(), dto.getRoomNumber(), dto.getRoomType(), dto.isAvailable());
  }

  public static RoomDTO toDTO(Room room) {
    return new RoomDTO(room.getId(), room.getRoomNumber(), room.getRoomType(), room.isAvailable());
  }

  public static List<RoomDTO> toDTOs(List<Room> room) {
    return room.stream().map(RoomDTO::toDTO).toList();
  }
}
