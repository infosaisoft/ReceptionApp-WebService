package com.harbor.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.bo.PatientBo;
import com.harbor.common.CustomIdGenerator;
import com.harbor.dao.PatientDao;
import com.harbor.dto.PatientDto;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao pdao;
	@Override
	public String registration(PatientDto pdto) throws Exception {
		PatientBo pbo=null;
		int count=0;
		String pid=null;
		//copy dto to bo
		pid=String.valueOf(CustomIdGenerator.getID());
		pid="PID-"+pid;
		pdto.setPatient_id(pid);
		pbo=new PatientBo();
		BeanUtils.copyProperties(pdto, pbo);
		//use dao
		count=pdao.insert(pbo);
		if(count==0) {
			return "fail";
		}
		return "success";
	}

}
