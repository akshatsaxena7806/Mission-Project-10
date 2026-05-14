package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ARObjectDTO;

public class ARObjectForm extends BaseForm{
	
	
	@NotEmpty(message = "userId is required")
    private String userId;
	
	@NotEmpty(message = "subscriptionType is required")
	private String subscriptionType;
	
	@NotEmpty(message = "renewwalDate is required")
	private String renewwalDate;
	
	@NotEmpty(message = "churnkRisk is required")
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
	public BaseDTO getDTO() {
	ARObjectDTO dto = initDTO(new ARObjectDTO());
	
	dto.setChurnkRisk(churnkRisk);
	dto.setUserId(userId);
	dto.setRenewwalDate(renewwalDate);
	dto.setSubscriptionType(subscriptionType);
	
	
		return dto;
	}


}
