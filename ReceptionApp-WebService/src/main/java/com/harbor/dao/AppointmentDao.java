package com.harbor.dao;

import java.util.Date;
import java.util.List;

import com.harbor.bo.AppointmentsBo;

public interface AppointmentDao {

	public int insertAppintment(AppointmentsBo abo);
	
	
	public  List<AppointmentsBo> getAllAppointment(String hid,Date date);
}
