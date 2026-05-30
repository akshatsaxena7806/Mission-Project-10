package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ATMSystemDTO;

public class ATMSystemForm extends BaseForm {
	
	@NotEmpty(message = "bankName is required")
	private String bankName;

	@NotEmpty(message = "location is required")
	private String location;
	
	@Min(1)
	@NotNull(message = "cashAvailable is required")
	private double cashAvailable;

	@Min(1)
	@NotNull(message = "securityCode is required")
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
	public BaseDTO getDTO() {
	
		ATMSystemDTO dto = initDTO(new ATMSystemDTO());
	
		dto.setSecurityCode(securityCode);
		dto.setBankName(bankName);
		dto.setCashAvailable(cashAvailable);
		dto.setLocation(location);
	
	return dto;
	}
	
	

}
