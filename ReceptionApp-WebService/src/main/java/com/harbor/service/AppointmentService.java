package com.harbor.service;

import java.util.Date;
import java.util.List;

import com.harbor.dto.AppointmentsDto;

public interface AppointmentService {
	
	public String registration(AppointmentsDto adto);
	
	public List<AppointmentsDto> getAllRecord(String hid,Date date);

}
