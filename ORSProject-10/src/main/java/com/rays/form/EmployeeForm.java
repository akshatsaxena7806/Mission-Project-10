package com.rays.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeeDTO;

public class EmployeeForm extends BaseForm{
	
	
	@NotEmpty(message = "employeeCode is required")
	private String employeeCode;

	@NotEmpty(message = "employeeName is required")
	private String employeeName;
	
	@NotEmpty(message = "state is required")
	private String state;

	@NotEmpty(message = "city is required")
	private String city;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public BaseDTO getDTO() {
	EmployeeDTO dto = initDTO(new EmployeeDTO());
	
	dto.setCity(city);
	dto.setState(state);
	dto.setEmployeeCode(employeeCode);
	dto.setEmployeeName(employeeName);
	
	return dto;
	}
}
