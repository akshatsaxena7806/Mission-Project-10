package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.HospitalSystemDTO;

public class HospitalSystemForm extends BaseForm {

	
	private String patientId;

	@NotEmpty(message = "patientName is required")
	private String patientName;

	@NotEmpty(message = "doctorName is required")
	private String doctorName;

	@NotEmpty(message = "disease is required")
	private String disease;

	@Min(1)
	@NotNull(message = "roomNumber is required")
	private int roomNumber;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
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
	public BaseDTO getDTO() {
	HospitalSystemDTO dto = initDTO(new HospitalSystemDTO());
	
	dto.setRoomNumber(roomNumber);
	dto.setPatientName(patientName);
	dto.setDoctorName(doctorName);
	dto.setDisease(disease);
	dto.setRoomNumber(roomNumber);	
		return dto;
	}
	

}
