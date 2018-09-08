package com.harbor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.harbor.dto.AppointmentsDto;
import com.harbor.service.AppointmentService;

@RestController
@CrossOrigin("*")
@EnableWebMvc
public class AppointmentController {

	@Autowired
	AppointmentService appservice;

	@CrossOrigin("*")
	@RequestMapping(value = "appointment", method = RequestMethod.POST, consumes = "application/JSON")
	public ResponseEntity<?> appointmentInsert(@RequestBody AppointmentsDto adto){
		String result=null;
		
		//use service
		result=appservice.registration(adto);
		
		if(result.equalsIgnoreCase("fail")) {
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	

	@CrossOrigin("*")
	@RequestMapping(value = "appointment", method = RequestMethod.GET, consumes = "application/JSON" ,produces="application/JSON")
	public ResponseEntity<?> displayAllRecord(@RequestBody AppointmentsDto adto, @PathVariable("hid") String hid,@RequestParam(value="date",required=false) Date date,Map<String,Object>map){
		List<AppointmentsDto>listdto=null;
		
		//use serice
		listdto=appservice.getAllRecord(hid, date);
		map.put("listdto",listdto);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	
	@InitBinder
	public  void myInitBinder(WebDataBinder binder){
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	
}
