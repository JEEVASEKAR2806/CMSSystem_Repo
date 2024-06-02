package com.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public interface MailService {

	
	public void sendMail(String toMail ,String subject,String body);
}
