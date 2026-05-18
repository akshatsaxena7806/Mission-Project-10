package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_GENDER")
public class GenderDTO extends BaseDTO{
	
	
	@Column(name = "genderCode" ,length = 55)
	private String genderCode ;

	@Column(name = "genderType" ,length = 55)
	private String genderType;

	@Column(name = "description" ,length = 55)
	private String description ;

	@Column(name = "status" ,length = 55)
	private String status ;



	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return genderType;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "genderCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return genderCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "genderCode";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Gender";
	}

}
