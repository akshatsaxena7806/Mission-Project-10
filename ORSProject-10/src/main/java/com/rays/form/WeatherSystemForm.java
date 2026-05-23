package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.WeatherSystemDTO;

public class WeatherSystemForm extends BaseForm {
	
	@NotEmpty(message = "cityName is required")
	private String cityName;

	@NotNull(message = "temperature is required")
	private int temperature;

	@NotNull(message = "humidity is required")
	private int humidity;

	@NotEmpty(message = "climate is required")
	private String climate;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	@Override
	public BaseDTO getDTO() {
		
		WeatherSystemDTO dto = initDTO(new WeatherSystemDTO());
		
		dto.setCityName(cityName);
		dto.setHumidity(humidity);
		dto.setTemperature(temperature);
		dto.setClimate(climate);
		
		return dto;
		
	}
	
	

}
