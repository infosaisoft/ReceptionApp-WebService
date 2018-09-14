package com.harbor.bo;

import java.sql.Timestamp;
import java.util.Date;

public class MainBillBo  {
	private String bill_id;
	private String hid;
	private String patient_name;
	private String patient_contact;
	private String add_charge;
	private String discount;
	private String net_amount;
	private String amount_paid;
	private String balance_amt;
	private String payment_mode;
	private Date bill_date;
	private Timestamp updated_date;
	private int status;
	
	private String sub_bill_id;
	private String tariff_name;
	private String service_name;
	private String category;
	private String rate;
	private String doctor;
	
	

	public String getBill_id() {
		return bill_id;
	}

	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
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

	public String getPatient_contact() {
		return patient_contact;
	}

	public void setPatient_contact(String patient_contact) {
		this.patient_contact = patient_contact;
	}

	public String getAdd_charge() {
		return add_charge;
	}

	public void setAdd_charge(String add_charge) {
		this.add_charge = add_charge;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getNet_amount() {
		return net_amount;
	}

	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}

	public String getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(String amount_paid) {
		this.amount_paid = amount_paid;
	}

	public String getBalance_amt() {
		return balance_amt;
	}

	public void setBalance_amt(String balance_amt) {
		this.balance_amt = balance_amt;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSub_bill_id() {
		return sub_bill_id;
	}

	public void setSub_bill_id(String sub_bill_id) {
		this.sub_bill_id = sub_bill_id;
	}

	public String getTariff_name() {
		return tariff_name;
	}

	public void setTariff_name(String tariff_name) {
		this.tariff_name = tariff_name;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	
	

}
