package com.harbor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.harbor.bo.MainBillBo;

@Repository
public class BillDaoImpl implements BillDao {
	
	private static final String INSERT_BILL_QUERY="INSERT INTO sub_billing (sub_bill_id,bill_id,tariff_name,service_name,category,rate,doctor) VALUES(?,?,?,?,?,?,?)";
	
	private static final String INSERT_MAIN_BILL_QUERY="INSERT INTO BILLING  (bill_id,hid,patient_name,patient_contact,add_charge,discount,net_amount,amount_paid,balance_amt,payment_mode,bill_date,status) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String VIEW_BILL_QUERY="SELECT bill_id, patient_name,patient_contact,net_amount,amount_paid,balance_amt ,updated_date from billing where hid=? ORDER BY  bill_date DESC";

	private static final String GET_BILL_BY_ID_QUERY="SELECT hid,patient_name,patient_contact,sub_bill_id,tariff_name,service_name,category,rate,doctor,add_charge,discount,net_amount,amount_paid,balance_amt,payment_mode,bill_date,updated_date,status FROM billing INNER JOIN sub_billing ON billing.`bill_id`= sub_billing.`bill_id` WHERE billing.`bill_id`=?";
	
	private static final String DELETE_BILL_BY_ID_QUERY="DELETE FROM  BILLING WHERE bill_id=?";
	
	@Autowired
	JdbcTemplate jt;
	
	
	
	@Override
	public int insertBill(MainBillBo mbbo) {
	   int count=0;
	    int subcount=0;
	  
	   count=jt.update(INSERT_MAIN_BILL_QUERY, mbbo.getBill_id(),mbbo.getHid(),mbbo.getPatient_name(),mbbo.getPatient_contact(),mbbo.getAdd_charge(),mbbo.getDiscount(),mbbo.getNet_amount(),mbbo.getAmount_paid(),mbbo.getBalance_amt(),mbbo.getPayment_mode(),new Date(),mbbo.getStatus());
	  if(count==1) {
	   subcount=jt.update(INSERT_BILL_QUERY, mbbo.getSub_bill_id(),mbbo.getBill_id(),mbbo.getTariff_name(),mbbo.getService_name(),mbbo.getCategory(),mbbo.getRate(),mbbo.getDoctor());       
	  }
	   return subcount;
	}



	@Override
	public List<MainBillBo> getBill(String hid) {
		List<MainBillBo>listbo=null;
		
		listbo=jt.query(VIEW_BILL_QUERY, new ResultSetExtractor<List<MainBillBo>>() {

			@Override
			public List<MainBillBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MainBillBo>listbo=new  ArrayList<>();
				MainBillBo bo=null;
				
				while(rs.next()) {
					bo=new MainBillBo();
					bo.setBill_id(rs.getString(1));
					bo.setPatient_name(rs.getString(2));
					bo.setPatient_contact(rs.getString(3));
					bo.setNet_amount(rs.getString(4));
					bo.setAmount_paid(rs.getString(5));
					bo.setBalance_amt(rs.getString(6));
					bo.setUpdated_date(rs.getTimestamp(7));
					listbo.add(bo);
					
				}
				return listbo;
			}
			
			
		}, hid);
		return listbo;
	}
	
	
	@Override
	public MainBillBo getBillByID(String bill_id) {
		MainBillBo bo=null;
		
		bo=jt.queryForObject(GET_BILL_BY_ID_QUERY, new RowMapper<MainBillBo>() {

			@Override
			public MainBillBo mapRow(ResultSet rs, int index) throws SQLException {
				MainBillBo bo=null;
				
				bo=new MainBillBo();
					bo.setHid(rs.getString(1));
					bo.setPatient_name(rs.getString(2));
					bo.setPatient_contact(rs.getString(3));
					bo.setSub_bill_id(rs.getString(4));
					bo.setTariff_name(rs.getString(5));
					bo.setService_name(rs.getString(6));
					bo.setCategory(rs.getString(7));
					bo.setRate(rs.getString(8));
					bo.setDoctor(rs.getString(9));
					bo.setAdd_charge(rs.getString(10));
					bo.setDiscount(rs.getString(11));
					bo.setNet_amount(rs.getString(12));
					bo.setAmount_paid(rs.getString(13));
					bo.setBalance_amt(rs.getString(14));
					bo.setPayment_mode(rs.getString(15));
					bo.setBill_date(rs.getDate(16));
					bo.setUpdated_date(rs.getTimestamp(17));
					bo.setStatus(rs.getInt(18));
		
				 
				return bo;
			}
			
			
		}, bill_id);
		return bo;
	}

 @Override
public int deleteBill(String bill_id) {
	int count=0;
	
	count=jt.update(DELETE_BILL_BY_ID_QUERY, bill_id);
	 
	return count;
}
 
 
 @Override
public int updateBill(MainBillBo bo) {
	// TODO Auto-generated method stub
	return 0;
}
	
	
	
}
