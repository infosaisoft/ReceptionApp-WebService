package com.harbor.service;

import java.util.List;

import com.harbor.bo.MainBillBo;
import com.harbor.dto.MainBillDto;

public interface BillService {
	
	public String registrationBill(MainBillBo mdto);
	public List<MainBillDto> viewAllBill(String hid);
	
	
	public MainBillDto viewBillById(String bill_id);
	
	public String removeill(String bill_id);

}
