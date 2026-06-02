package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_HOSPITALSYSTEM")
public class HospitalSystemDTO extends BaseDTO {

	@Column(name = "patientId",length = 55)
	private String patientId;
	
	@Column(name = "patientName",length = 55)
	private String patientName;

	@Column(name = "doctorName",length = 55)
	private String doctorName;

	@Column(name = "disease",length = 55)
	private String disease;

	@Column(name = "roomNumber",length = 55)
	private int  roomNumber;
	
	
	public String getPatientName() {
		return patientName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return patientName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "patientName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return patientName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "patientName";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "hospital list";
	}

}
