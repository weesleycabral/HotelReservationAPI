package com.hotel.api.dtos;

import java.util.List;

import com.hotel.api.entities.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
  private Long id;
  private String email;
  private String name;

  public static Client toEntity(ClientDTO dto) {
    return new Client(dto.getId(), dto.getEmail(), dto.getName());
  }

  public static ClientDTO toDTO(Client client) {
    return new ClientDTO(client.getId(), client.getEmail(), client.getName());
  }

  public static List<ClientDTO> toDTOs(List<Client> client) {
    return client.stream().map(ClientDTO::toDTO).toList();
  }
}
