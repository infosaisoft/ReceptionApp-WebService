package com.harbor.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.dto.PatientDto;
import com.harbor.exception.ApiError;
import com.harbor.service.PatientService;

@RestController
@CrossOrigin("*")
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@CrossOrigin("*")
	@RequestMapping(value="registration",method=RequestMethod.POST,consumes="application/JSON")
	public ResponseEntity<?> registration(@RequestBody PatientDto pdto,BindingResult error,Map<String,Object>map)throws Exception {
		String result=null;
		
		HttpHeaders header = new HttpHeaders();
		
		System.out.println("patient name:::::::"+pdto.getName());
			result=pservice.registration(pdto);
			/*List<ObjectError>e	=	error.getAllErrors();
			ApiError errors=new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, " unquie elements",error.toString());
			map.put("erros", errors);*/
			
			if (result.equals("fail")) {
				System.out.println(new ResponseEntity<String>(header, HttpStatus.INTERNAL_SERVER_ERROR));
				return new ResponseEntity<String>(header, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			System.out.println(new  ResponseEntity<String>(header, HttpStatus.OK));
			return new ResponseEntity<String>(header, HttpStatus.OK);
		
	}
}

