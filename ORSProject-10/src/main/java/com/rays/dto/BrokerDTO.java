package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_BROKER")
public class BrokerDTO extends BaseDTO{
	
	@Column(name = "brokerId" ,length = 55)
	private String  brokerId;

	@Column(name = "brokerName", length = 55)
	private String brokerName;

	@Column(name = "contactNumber", length = 55)
	private String contactNumber;

	@Column(name = "company", length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return brokerName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "brokerId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return brokerId;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return brokerId;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " Broker ";
	}

}
