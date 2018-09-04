package com.harbor.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.bo.loginBo;
import com.harbor.dao.LoginDao;
import com.harbor.dto.LoginDto;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao dao;

	@Override
	public String verfiyLogin(LoginDto dto) {
      loginBo bo=null;
      int count=0;
      //copy bo to dto
      BeanUtils.copyProperties(bo, dto);
      count=dao.loginUser(bo);
      
      if(count==0) {
    	  return "fail";
      }
		return "success";
	}

}
