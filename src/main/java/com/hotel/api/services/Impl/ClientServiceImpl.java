package com.hotel.api.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.api.dtos.ClientDTO;
import com.hotel.api.dtos.data.ClientDataDTO;
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
  public void createClient(ClientDataDTO client) {
    clientRepository.save(client.toEntity());
  }

  @Override
  public Client getClientById(Long id) {
    Client client;
    client = clientRepository.findById(id).get();
    return client;

  }

  @Override
  public List<ClientDTO> getAllClients() {
    List<Client> clients = clientRepository.findAll();
    return ClientDTO.toDTOs(clients);
  }

  @Override
  public void updateClient(Long id, ClientDataDTO clientDTO) {
    Client updatedClient = clientDTO.toEntity();
    updatedClient.setId(id);
    clientRepository.save(updatedClient);

  }

  @Override
  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

}
