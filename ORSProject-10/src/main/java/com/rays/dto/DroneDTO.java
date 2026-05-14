package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_DRONE")
public class DroneDTO extends BaseDTO {

	
	@Column(name = "droneCode",length = 55)
	private String droneCode;

	@Column(name = "operatorName",length = 55)
	private String operatorName;

	@Column(name = "deliveryZone",length = 55)
	private String deliveryZone;

	@Column(name = "status",length = 55)
	private String status;

	public String getDroneCode() {
		return droneCode;
	}

	public void setDroneCode(String droneCode) {
		this.droneCode = droneCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDeliveryZone() {
		return deliveryZone;
	}

	public void setDeliveryZone(String deliveryZone) {
		this.deliveryZone = deliveryZone;
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
		return droneCode;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "droneCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return droneCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "droneCode";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Drone Delivry";
	}
	
	
	

}
