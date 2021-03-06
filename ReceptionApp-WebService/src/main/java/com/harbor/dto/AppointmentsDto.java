package com.harbor.dto;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentsDto implements Serializable{
	
	
	private String app_id;
	private String hid;
	private String patient_name;
	private String contact;
	private String time;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date1;
	private String date;
	private int status;
	
	
	public String getApp_id() {
		return app_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
		
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
