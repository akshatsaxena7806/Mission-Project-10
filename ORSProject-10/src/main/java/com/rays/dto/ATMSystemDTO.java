package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "bankName")
public class ATMSystemDTO extends BaseDTO{
	
	
	@Column(name = "bankName", length = 55)
	private String bankName;

	@Column(name = "location", length = 55)
	private String location;

	
	@Column(name = "cashAvailable", length = 55)
	private double cashAvailable;

	@Column(name = "securityCode", length = 55)
	private int securityCode;

	

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	public double getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(double cashAvailable) {
		this.cashAvailable = cashAvailable;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return bankName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "bankName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return bankName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return bankName;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "ATM System";
	}

}
