package com.hotel.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.api.dtos.EmailDTO;
import com.hotel.api.services.EmailService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/email")
@AllArgsConstructor
public class EmailController {

  private final EmailService emailService;

  @PostMapping
  public void sendMail(@RequestBody EmailDTO emailDTO) {
    emailService.sendMail(emailDTO);
  }
}
