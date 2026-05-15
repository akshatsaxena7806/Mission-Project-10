package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_LIVESTREAMING")
public class LiveStreamingDTO extends BaseDTO {

	@Column(name = "streamCode",length = 55)
	private String streamCode;

	@Column(name = "streamerName",length = 55)
	private String streamerName;

	@Column(name = "viewersCount",length = 55)
	private String viewersCount;

	@Column(name = "status",length = 55)
	private String status;



	public String getStreamCode() {
		return streamCode;
	}

	public void setStreamCode(String streamCode) {
		this.streamCode = streamCode;
	}

	public String getStreamerName() {
		return streamerName;
	}

	public void setStreamerName(String streamerName) {
		this.streamerName = streamerName;
	}

	public String getViewersCount() {
		return viewersCount;
	}

	public void setViewersCount(String viewersCount) {
		this.viewersCount = viewersCount;
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
		return streamerName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "streamCode";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return streamCode;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "streamCode";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Live Streaming";
	}
	
	

}
