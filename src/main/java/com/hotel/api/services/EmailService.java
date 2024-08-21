package com.hotel.api.services;

import com.hotel.api.dtos.EmailDTO;

public interface EmailService {
  public void sendMail(EmailDTO emailDTO);

}