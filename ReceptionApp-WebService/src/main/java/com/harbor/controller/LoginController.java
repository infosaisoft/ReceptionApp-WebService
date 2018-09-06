package com.harbor.controller;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.harbor.dto.LoginDto;
import com.harbor.service.LoginService;

@RestController

@CrossOrigin("*")
public class LoginController {

	@Autowired
	LoginService service;

	@CrossOrigin("*")
	@RequestMapping(value="login",method=RequestMethod.POST, consumes = { "application/JSON","application/XML" },produces={ "application/JSON","application/XML" })
	public ResponseEntity<?>  Verfication(@RequestBody LoginDto dto, HttpServletResponse res,UriComponentsBuilder ucbuilder) {
		String result = null;
		res.setContentType("application/JSON");
		result = service.verfiyLogin(dto);
		System.out.println(result);

		HttpHeaders header = new HttpHeaders();
		header.add("username", dto.getUsername());
		if (result.equals("fail")) {
			return new ResponseEntity<String>(header, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>(header, HttpStatus.OK);

	}
	
	
}
