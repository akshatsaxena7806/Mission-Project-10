package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LiveStreamingDTO;


public class LiveStreamingForm extends BaseForm {

	@NotEmpty(message = "streamCode is requeired")
	private String streamCode;

	@NotEmpty(message = "streamerName is requeired")
	private String streamerName;

	@NotEmpty(message = "viewersCount is requeired")
	private String viewersCount;

	@NotEmpty(message = "status is requeired")
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

	public BaseDTO getDTO() {

		LiveStreamingDTO dto = initDTO(new LiveStreamingDTO());

		dto.setStatus(status);
		dto.setStreamCode(streamCode);
		dto.setStreamerName(streamerName);
		dto.setViewersCount(viewersCount);

		return dto;
	}

}
