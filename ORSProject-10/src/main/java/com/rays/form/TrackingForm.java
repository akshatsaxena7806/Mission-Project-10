package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TrackingDTO;

public class TrackingForm extends BaseForm{

	
	@NotEmpty(message = "trackintId is required")
	private String  trackintId;

	@NotEmpty(message = "trackingNumber is required" )
	private String trackingNumber;

	@NotEmpty(message = "currentLocation is required" )
	private String currentLocation;

	@NotEmpty(message = "status is required")
	private String status;

	public String getTrackintId() {
		return trackintId;
	}

	public void setTrackintId(String trackintId) {
		this.trackintId = trackintId;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDTO() {
	TrackingDTO dto = initDTO(new TrackingDTO());
	
	dto.setTrackingNumber(trackingNumber);
	dto.setTrackintId(trackintId);
	dto.setStatus(status);
	dto.setCurrentLocation(currentLocation);
	
	return dto;
	}
}
