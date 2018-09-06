package com.harbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.dto.LoginDto;
import com.harbor.exception.ApiError;
import com.harbor.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService service;
	

	public String Verfication(@RequestBody LoginDto dto) {
		String result=null;
		result=service.verfiyLogin(dto);
		
		return result;
		
	}
}
