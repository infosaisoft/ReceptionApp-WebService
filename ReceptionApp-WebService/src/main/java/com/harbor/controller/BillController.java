package com.harbor.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.bo.MainBillBo;
import com.harbor.dto.MainBillDto;
import com.harbor.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	BillService billservice;
	
	@CrossOrigin("*")
	@RequestMapping(value="bill",method=RequestMethod.POST,consumes="application/JSON")
	public ResponseEntity<?> registrationSubBill( @RequestBody MainBillBo mdto){
		String result=null;
		
		//use service
		result=billservice.registrationBill(mdto);
		if(result.equals("success")) {
		return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@CrossOrigin("*")
	@GetMapping("viewbill")
	public List<MainBillDto> displayAllBill(@RequestParam(value="hid",defaultValue="hid1",required=true) String hid,Map<String,Object>map){
		List<MainBillDto>listdto=null;
		System.out.println(hid);
		//use service
		listdto=billservice.viewAllBill(hid);
		
		map.put("listdto", listdto);
		
		return listdto;
	}
	
	@CrossOrigin("*")
	@GetMapping("viewbillbyid")
	public MainBillDto displayBillById(@RequestParam(value="bill_id",defaultValue="BID-6906971351") String bill_id,Map<String,Object>map) {
		MainBillDto dto=null;
				
		//use service
		dto=billservice.viewBillById(bill_id);
		map.put("dto", dto);
		return dto;
	}
	
	
	

	@DeleteMapping("deletebillbyid")
	public ResponseEntity<?> deleteBillById(@RequestParam(value="bill_id",defaultValue="BID-6906971351") String bill_id,Map<String,Object>map) {
		String delete=null;
		//use service
		delete=billservice.removeill(bill_id);
		
		return new ResponseEntity<String>(delete, HttpStatus.ACCEPTED);
	}

	

}
