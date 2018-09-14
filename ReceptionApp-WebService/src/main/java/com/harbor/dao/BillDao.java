package com.harbor.dao;

import java.util.List;

import com.harbor.bo.MainBillBo;
import com.harbor.bo.SubBillBo;

public interface BillDao {

	public  int insertBill(MainBillBo mbbo);
	
	public List<MainBillBo> getBill(String hid);
	
	public MainBillBo getBillByID(String bill_id);
	
	public int deleteBill(String bill_id);
	
	public int updateBill(MainBillBo bo);
	
}
