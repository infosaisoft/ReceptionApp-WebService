package com.harbor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.harbor.bo.loginBo;

@Repository
public class LoginDaoImpl implements LoginDao {

	private static final String CHECKUSER="SELECT COUNT(*) FROM hospital_admin WHERE username=? AND password=? AND role='reception' "; 
	
	@Autowired
	JdbcTemplate jt;
	@Override
	public int loginUser(loginBo bo) {
		int count=0;
		count=jt.queryForObject(CHECKUSER,Integer.class, bo.getUsername(), bo.getPassword());	
		System.out.println("dao ==== "+count);
		return count;
	}

}
