package com.hotel.api.services.Impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hotel.api.dtos.EmailDTO;
import com.hotel.api.services.EmailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender javaMailSender;

  private static final String NOREPLY_EMAIL = "noreply@email.com";

  public void sendMail(EmailDTO emailDTO) {
    var message = new SimpleMailMessage();
    message.setFrom(NOREPLY_EMAIL);
    message.setTo(emailDTO.to());
    message.setSubject(emailDTO.subject());
    message.setText(emailDTO.body());
    javaMailSender.send(message);
  }
}
