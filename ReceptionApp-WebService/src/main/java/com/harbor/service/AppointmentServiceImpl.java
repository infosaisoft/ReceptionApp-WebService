package com.harbor.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.bo.AppointmentsBo;
import com.harbor.common.CustomIdGenerator;
import com.harbor.dao.AppointmentDao;
import com.harbor.dto.AppointmentsDto;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDao  ado;

	@Override
	public String registration(AppointmentsDto adto) {
	AppointmentsBo abo=null;
	int count=0;
	String appid=null;
	
	appid=String.valueOf(CustomIdGenerator.getID());
	
	appid="APP-"+appid;
	        //copy dto to bo
	       adto.setApp_id(appid);
	   abo=new AppointmentsBo();
	   BeanUtils.copyProperties(adto, abo);
	   
	   
	   //use dao
	   count=ado.insertAppintment(abo);
	   
	   
	   if(count==0) {
		   
		   return "fail";
	   }
	
		return "success";
	}

}
