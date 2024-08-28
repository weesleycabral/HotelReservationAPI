package com.hotel.api.services;

import java.util.List;

import com.hotel.api.dtos.ClientDTO;
import com.hotel.api.dtos.data.ClientDataDTO;
import com.hotel.api.entities.Client;

public interface ClientService {
  public void createClient(ClientDataDTO client);

  public Client getClientById(Long id);

  public List<ClientDTO> getAllClients();

  public void updateClient(Long id, ClientDataDTO clientDTO);

  public void deleteAllClients();

  public void deleteClientById(Long id);
}
