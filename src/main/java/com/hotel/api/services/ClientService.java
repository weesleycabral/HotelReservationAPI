package com.hotel.api.services;

import java.util.List;

import com.hotel.api.entities.Client;

public interface ClientService {
  public Client createClient(Client client);

  public Client getClient(Long id);

  public List<Client> getAllClients();

  public Client updateClient(Long id, Client client);

  public void deleteClient(Long id);
}
