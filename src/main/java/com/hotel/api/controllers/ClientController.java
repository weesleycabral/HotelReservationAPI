package com.hotel.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.dtos.ClientDTO;
import com.hotel.api.dtos.data.ClientDataDTO;
import com.hotel.api.entities.Client;
import com.hotel.api.services.ClientService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {

  private final ClientService clientService;

  @PostMapping("/new")
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createClient(@RequestBody ClientDataDTO clientDTO) {
    clientService.createClient(clientDTO);
  }

  @GetMapping("/list")
  @ResponseStatus(value = HttpStatus.OK)
  public List<ClientDTO> listClients() {
    return clientService.getAllClients();
  }

  @GetMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public Client getClientById(@PathVariable("id") Long id) {
    return clientService.getClientById(id);
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDataDTO clientDTO) {
    clientService.updateClient(id, clientDTO);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteClient(@PathVariable("id") Long id) {
    clientService.deleteClient(id);
  }

}
