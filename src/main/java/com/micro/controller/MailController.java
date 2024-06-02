package com.micro.controller;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.MailService;

@RestController
@CrossOrigin("http://localhost:3000")
public class MailController {

	@Autowired
    MailService service;
	
	String msg="";
    @PostMapping("/sendmailToCustomer/{email}/{message}")
    public String doSend(@PathVariable("email") String email,@PathVariable("message") String message ) throws UnsupportedEncodingException {
    	
   	System.out.println(email);
   	System.out.println(message);	
    	service.sendMail(email,message, msg);
   	return "Success";
    }
}
