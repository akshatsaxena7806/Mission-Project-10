package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_AROBJECT")
public class ARObjectDTO extends BaseDTO {
	
	
	@Column(name = "userId", length = 55)
	private String userId;
	
	@Column(name = "subscriptionType", length = 55)
	private String subscriptionType;

	@Column(name = "renewwalDate", length = 55)
	private String renewwalDate;
	
	@Column(name = "ChurnkRisk", length = 55)
	private String churnkRisk;
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getRenewwalDate() {
		return renewwalDate;
	}

	public void setRenewwalDate(String renewwalDate) {
		this.renewwalDate = renewwalDate;
	}

	

	public String getChurnkRisk() {
		return churnkRisk;
	}

	public void setChurnkRisk(String churnkRisk) {
		this.churnkRisk = churnkRisk;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return subscriptionType;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "userId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "userId";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "ARObeject";
	}
	
	
	
	
	

}
