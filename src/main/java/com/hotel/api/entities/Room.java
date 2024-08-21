package com.hotel.api.entities;

import com.hotel.api.enums.RoomType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "room")
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "roomNumber")
  private String roomNumber;

  @Column(name = "roomType")
  private RoomType roomType;

  @Column(name = "isAvailable")
  private boolean isAvailable;

  public Room(String roomNumber, RoomType roomType) {
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    // this.isAvailable = true;
  }

}
