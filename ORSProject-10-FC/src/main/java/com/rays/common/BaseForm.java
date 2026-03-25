package com.rays.common;

public class BaseForm {

	protected Long id;

	protected String createdBy;

	protected String modifiedBy;

	protected long createdDateTime;

	protected long modifiedDateTime;

	private Long[] ids;

	private int pageNo = 0;

	private int pageSize = 5;

	private String operation;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public BaseDTO getDTO() {
		return null;
	}

	public <T extends BaseDTO> T initDTO(T dto) {

		if (id != null && id>0) {

			dto.setId(id);

		} else {
			dto.setId(null);
		}

		return dto;

	}

}
