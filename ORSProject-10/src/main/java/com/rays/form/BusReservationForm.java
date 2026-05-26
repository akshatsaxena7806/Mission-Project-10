package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BusReservationDTO;

public class BusReservationForm extends BaseForm {

	@NotEmpty(message = "busNo is required")
	private String busNo;

	@NotEmpty(message = "passengerName is required")
	private String passengerName;

	@NotEmpty(message = "source is required")
	private String source;

	@NotEmpty(message = "destination is required")
	private String destination;

	@NotNull(message = "ticketFare is required")
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
	public BaseDTO getDTO() {
	BusReservationDTO dto = initDTO(new BusReservationDTO());
	
	dto.setBusNo(busNo);
	dto.setPassengerName(passengerName);
	dto.setTicketFare(ticketFare);
	dto.setDestination(destination);
	dto.setSource(source);
	
		return dto;
	}
	
	
}
