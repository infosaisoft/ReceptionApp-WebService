package com.harbor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> appointmentInsert(@RequestBody AppointmentsDto adto) throws ParseException{
		String result=null;
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(adto.getDate());
		System.out.println(date);
		//use service
		adto.setDate1(date);
		result=appservice.registration(adto);
		HttpHeaders header = new HttpHeaders();
		if(result.equalsIgnoreCase("fail")) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(header, HttpStatus.OK);
	}
	

	
	@CrossOrigin("*")
	@GetMapping(value="appointment")
	public List<AppointmentsDto> displayAllRecord(@RequestParam("hid") String hid,@RequestParam("appdate") @DateTimeFormat(pattern="dd-MM-yyyy") String date1, Map<String,Object>map) throws ParseException{
	List<AppointmentsDto>listdto=null;
	    

	Date date=new SimpleDateFormat("yyyy-MM-dd").parse(date1);
	//use serice
	listdto=appservice.getAllRecord(hid, date);
	map.put("listdto",listdto);
	return listdto;
	}	
	
	
	@InitBinder
	public  void myInitBinder(WebDataBinder binder){
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	
}
