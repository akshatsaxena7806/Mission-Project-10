package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_EMPLOYEE")
public class EmployeeDTO extends BaseDTO {

	@Column(name = "employeeCode" ,length = 55)
	private String employeeCode;

	@Column(name = "employeeName" ,length = 55)
	private String employeeName;

	@Column(name = "state" ,length = 55)
	private String state;

	@Column(name = "city" ,length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return employeeCode;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "employeeCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return employeeCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return employeeCode;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Employee";
	}

}
