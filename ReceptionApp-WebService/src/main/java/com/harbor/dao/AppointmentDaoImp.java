package com.harbor.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.bo.AppointmentsBo;
@Repository
public class AppointmentDaoImp implements AppointmentDao {

	private static final String INSERT_QUERY="INSERT INTO appointments VALUES(?,?,?,?,?,?)";
	
	
	@Autowired
	JdbcTemplate jt;
	
	
	@Override
	public int insertAppintment(AppointmentsBo abo) {
		int count=0;
		count=jt.update(INSERT_QUERY, abo.getApp_id(),abo.getHid(),abo.getPatient_name(),abo.getContact(),abo.getTime(),abo.getDate());

		
		return count;
	}

}
