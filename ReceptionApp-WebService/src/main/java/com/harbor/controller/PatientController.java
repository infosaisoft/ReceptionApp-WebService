package com.harbor.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.harbor.dto.PatientDto;
import com.harbor.exception.ApiError;
import com.harbor.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService pservice;

	@RequestMapping(value = "registration", method = RequestMethod.POST, consumes = "application/JSON")
	public ResponseEntity<?> registration(@RequestBody PatientDto pdto, BindingResult erros, Map<String, Object> map)
			throws Exception {
		String result = null;
		String filename = null;
		MultipartFile file = null;
		OutputStream os = null;
		InputStream is = null;
		// get upload file name
		file = pdto.getPhoto();
		filename = file.getOriginalFilename();

		try {

			// create output stram to destfile on server machine file system
			os = new FileOutputStream("c://upload//" + filename);

			// create input stram to completing fileupload
			is = file.getInputStream();

			// perform file copy operation
			IOUtils.copy(is, os);
		}

		catch (IOException ie) {
			ie.printStackTrace();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		finally {
			
			try {
			    
				if(os!=null) {
					os.close();
				}
			} 
			
			catch (IOException io) {
			      io.printStackTrace();
			}
			
			
		try {
			    
				if(is!=null) {
					is.close();
				}
			} 
			
			catch (IOException ise) {
			      ise.printStackTrace();
			}
	
			
		}


		System.out.println("patient name:::::::" + pdto.getName());
		pdto.setPhoto_name(filename);
		result = pservice.registration(pdto);
		List<ObjectError> e = erros.getAllErrors();
		ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, " unquie elements", e.get(0).toString());
		map.put("erros", erros);
		
		
		 return new ResponseEntity("Success"
	                + filename, HttpStatus.OK);

	}
}
