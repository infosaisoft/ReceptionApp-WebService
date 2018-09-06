package com.harbor.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.dto.PatientDto;
import com.harbor.exception.ApiError;
import com.harbor.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService pservice;
	
	
	@RequestMapping(value="registration",method=RequestMethod.POST,consumes="application/JSON")
	public  String registration(@RequestBody PatientDto pdto,BindingResult erros,Map<String,Object>map)throws Exception {
		String result=null;
		
		System.out.println("patient name:::::::"+pdto.getName());
			result=pservice.registration(pdto);
			List<ObjectError>e	=	erros.getAllErrors();
			ApiError error=new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, " unquie elements", e.get(0).toString());
			map.put("erros", erros);
			return result;
		
	}
}

