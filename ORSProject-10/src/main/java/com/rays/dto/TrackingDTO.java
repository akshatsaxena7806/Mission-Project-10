package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;



@Entity
@Table(name = "ST_TRACKING")
public class TrackingDTO extends BaseDTO {
	
	@Column(name = "trackintId",length = 55)
	private String  trackintId;

	@Column(name = "trackingNumber",length = 55)
	private String trackingNumber;

	@Column(name = "currentLocation",length = 55)
	private String currentLocation;

	@Column(name = "status",length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "trackintId";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return trackintId;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "trackintId";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Tracking";
	}

}
