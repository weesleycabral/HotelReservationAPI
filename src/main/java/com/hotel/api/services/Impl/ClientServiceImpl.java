package com.hotel.api.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.entities.Client;
import com.hotel.api.repositories.ClientRepository;
import com.hotel.api.services.ClientService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Override
  public Client createClient(Client client) {
    return clientRepository.save(client);
  }

  @Override
  public Client getClient(Long id) {
    Client client;
    client = clientRepository.findById(id).get();
    return client;

  }

  @Override
  public List<Client> getAllClients() {
    List<Client> clients;
    clients = clientRepository.findAll();
    return clients;
  }

  @Override
  public Client updateClient(Long id, Client client) {
    Client updatedClient;
    updatedClient = clientRepository.save(client);
    return updatedClient;
  }

  @Override
  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

}
