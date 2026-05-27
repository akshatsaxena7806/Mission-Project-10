package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ElectricityBillDTO;

public class ElectricityBillForm extends BaseForm{

	@NotNull(message ="billId is required")
	private String billId;

	@NotEmpty(message ="customerName is required")
	private String customerName;

	@NotNull(message ="unitsConsumed is required")
	private double  unitsConsumed;

	@NotNull(message =" billAmount is required")
	private double billAmount;

	@NotNull(message ="dueDate is required")
	private Date dueDate;

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public BaseDTO getDTO() {
	ElectricityBillDTO dto = initDTO(new ElectricityBillDTO());
	
	dto.setCustomerName(customerName);
	dto.setBillId(billId);
	dto.setUnitsConsumed(unitsConsumed);
	dto.setDueDate(dueDate);
	dto.setBillAmount(billAmount);
		return dto;
	}


}
