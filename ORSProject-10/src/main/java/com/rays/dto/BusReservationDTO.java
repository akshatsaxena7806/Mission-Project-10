package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_BUSRESERVATION")
public class BusReservationDTO extends BaseDTO {

	
	@Column(name = "busNo", length = 55)
	private String busNo;

	@Column(name = "passengerName", length = 55)
	private String passengerName;

	@Column(name = "source", length = 55)
	private String source;

	@Column(name = "destination", length = 55)
	private String destination;

	@Column(name = "ticketFare", length = 55)
	private int ticketFare;
	

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(int ticketFare) {
		this.ticketFare = ticketFare;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return busNo;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "busNo";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return busNo;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return busNo;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Bus Reservation";
	}

}
