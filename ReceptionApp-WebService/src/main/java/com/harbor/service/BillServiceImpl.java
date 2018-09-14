package com.harbor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.bo.MainBillBo;
import com.harbor.bo.SubBillBo;
import com.harbor.common.CustomIdGenerator;
import com.harbor.dao.BillDao;
import com.harbor.dto.MainBillDto;
import com.harbor.dto.SubBillDto;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillDao billdao;

	@Override
	public String registrationBill(MainBillBo mdto) {
		MainBillBo mbo=null;
		SubBillBo subbo=null;
		String bill_id=null,sub_bill_id=null;
		
		int count=0;
	//copy dto to bo
		bill_id=String.valueOf(CustomIdGenerator.getID());
	    sub_bill_id=String.valueOf(CustomIdGenerator.getID());
	
		//genrate bill id 
		bill_id="BID-"+bill_id;
		sub_bill_id="SID-"+sub_bill_id;
		System.out.println(sub_bill_id);
		mbo=new MainBillBo();
	
		
		
		//copy dto to bo
		BeanUtils.copyProperties(mdto, mbo);
		mbo.setBill_id(bill_id);
	mbo.setSub_bill_id(sub_bill_id);

		//use dao
		count=billdao.insertBill(mbo);
		
		if(count==0) {
			return "fail";
		}
		return "success";
	}

	@Override
	public List<MainBillDto> viewAllBill(String hid) {
		List<MainBillDto>listdto=new ArrayList<>();
		List<MainBillBo>listbo=null;
		
		//use dao
		listbo=billdao.getBill(hid);
		listbo.forEach(bo->{
			MainBillDto dto=new MainBillDto();
			//copy bo to dto
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}
	
	
	@Override
	public MainBillDto viewBillById(String bill_id) {
		MainBillBo bo=null;
		MainBillDto dto=null;
		
		//use dao
		bo=billdao.getBillByID(bill_id);
		
		//copy bo to dto
		dto=new MainBillDto();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String removeill(String bill_id) {
		int count=0;
		
		
		count=billdao.deleteBill(bill_id);
		if(count==0) {
			return "fail";
		}
		return "success";
	}

}
