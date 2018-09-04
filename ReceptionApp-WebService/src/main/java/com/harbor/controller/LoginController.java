package com.harbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harbor.dto.LoginDto;
import com.harbor.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	
	@RequestMapping(value="login",method=RequestMethod.POST,consumes="application/json")
	public String Verfication(@RequestBody LoginDto dto) {
		String result=null;
		result=service.verfiyLogin(dto);
		return result;
		
	}
}
