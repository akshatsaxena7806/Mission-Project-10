package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_WEATHERSYSTEM")
public class WeatherSystemDTO extends BaseDTO {
	
	@Column(name = "cityName", length = 55)
	private String cityName;

	@Column(name = "temperature", length = 55)
	private int temperature;

    @Column(name = "humidity", length = 55)
	private int humidity;

    @Column(name = "climate", length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return cityName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "cityName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return cityName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return cityName;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Weather system";
	}

}
