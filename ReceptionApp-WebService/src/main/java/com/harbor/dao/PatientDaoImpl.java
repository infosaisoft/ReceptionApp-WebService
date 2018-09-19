package com.harbor.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.bo.PatientBo;

@Repository
public class PatientDaoImpl implements PatientDao {

	private static final String INSERT_PATIENT="INSERT INTO patients (patient_id, name, aadhar, contact, address, city, state, zip, gender, age, email, creation_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	
	@Autowired
	JdbcTemplate jt;
	@Override
	public int insert(PatientBo pbo) {
		int count=0;
		count=jt.update(INSERT_PATIENT, pbo.getPatient_id(),pbo.getName(),pbo.getAadhar(),pbo.getContact(),pbo.getAddress(),pbo.getCity(),pbo.getState(),pbo.getZip(),pbo.getGender(),pbo.getAge(),pbo.getEmail(),new Date());
		
		return count;
	}

}
