package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BrokerDTO;

public class BrokerForm extends BaseForm{


	@NotEmpty(message = "brokerId  is required")
	private String  brokerId;

	@NotEmpty(message = "brokerName is required")
	private String brokerName;

	@NotEmpty(message = "contactNumber is required")
	private String contactNumber;
	
	@NotEmpty(message = "company is required")
	private String company;

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	 @Override
	public BaseDTO getDTO() {
	BrokerDTO dto = initDTO(new BrokerDTO());
	
	dto.setBrokerId(brokerId);
	dto.setBrokerName(brokerName);
	dto.setContactNumber(contactNumber);
	dto.setCompany(company);
		return dto;
	}
}
