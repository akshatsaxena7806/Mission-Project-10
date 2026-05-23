package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_ACHIEVEMENTBADGE")
public class AchievementBadgeDTO extends BaseDTO {

	@Column(name = "badgeCode",length = 55)
	private String badgeCode;

	@Column(name = "badgeName",length = 55)
	private String badgeName;		

	@Column(name = "earnedBy",length = 55)
	private String earnedBy;

	@Column(name = "status",length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return badgeCode;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "badgeCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return badgeCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "badgeCode";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " Achievement Badge ";
	}

}
