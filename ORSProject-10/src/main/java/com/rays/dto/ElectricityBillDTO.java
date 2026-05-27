package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_ELECTRICITYBILL")
public class ElectricityBillDTO extends BaseDTO{
	
	
	@Column(name = "billId" ,length = 55)
	private String billId;

	@Column(name = "customerName" ,length = 55)
	private String customerName;

	@Column(name = "unitsConsumed" )
	private double  unitsConsumed;

	@Column(name = "billAmount" )
	private double billAmount;

	@Column(name = "dueDate")
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
	public String getValue() {
		// TODO Auto-generated method stub
		return customerName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "billId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return billId;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "billId";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "ElectricityBill";
	}

}
