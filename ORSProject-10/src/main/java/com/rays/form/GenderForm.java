package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.GenderDTO;

public class GenderForm extends BaseForm{
	
	@NotEmpty(message = "genderCode is required")
	private String genderCode ;

	@NotEmpty(message = "genderType is required")
	private String genderType;

	@NotEmpty(message = "description is required")
	private String description ;

	@NotEmpty(message = "status is required")
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
	public BaseDTO getDTO() {
	GenderDTO dto = initDTO(new GenderDTO());
	
	dto.setGenderCode(genderCode);
	dto.setGenderType(genderType);
	dto.setStatus(status);
	dto.setDescription(description);
		return dto;
	}

	
	

}
