package com.hotel.api.dtos.data;

import com.hotel.api.entities.Client;

public record ClientDataDTO(String name, String email) {

  public Client toEntity() {
    return new Client(name, email);
  }

}
