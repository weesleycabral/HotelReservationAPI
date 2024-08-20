package com.hotel.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.api.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
  Client findByName(String name);

  Client findByEmail(String email);

}
