package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AchievementBadgeDTO;

public class AchievementBadgeForm  extends BaseForm{

	@NotEmpty(message = "badgeCode is required")
	private String badgeCode;

	@NotEmpty(message = "badgeName is required")
	private String badgeName;

	@NotEmpty(message = "earnedBy is required")
	private String earnedBy;
	
	@NotEmpty(message = "status is required")
	private String status;

	public String getBadgeCode() {
		return badgeCode;
	}

	public void setBadgeCode(String badgeCode) {
		this.badgeCode = badgeCode;
	}

	public String getBadgeName() {
		return badgeName;
	}

	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}

	public String getEarnedBy() {
		return earnedBy;
	}

	public void setEarnedBy(String earnedBy) {
		this.earnedBy = earnedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public BaseDTO getDTO() {
		AchievementBadgeDTO dto = initDTO(new AchievementBadgeDTO());
		
		dto.setEarnedBy(earnedBy);
		dto.setStatus(status);
		dto.setBadgeCode(badgeCode);
		dto.setBadgeName(badgeName);
		return dto;
	}
}
