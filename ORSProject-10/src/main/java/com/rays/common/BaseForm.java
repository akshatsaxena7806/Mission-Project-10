package com.rays.common;

/**
 * Base form class for handling form data and pagination.
 * 
 * @author Akshat Saxena
 */
public class BaseForm {

	/** Primary key ID */
	protected Long id;

	/** User who created the record */
	protected String createdBy;

	/** User who last modified the record */
	protected String modifiedBy;

	/** Record creation timestamp */
	protected long createdDateTime;

	/** Last modification timestamp */
	protected long modifiedDateTime;

	/** Array of IDs for bulk operations */
	private Long[] ids;

	/** Current page number for pagination */
	private int pageNo = 0;

	/** Number of records per page */
	private int pageSize = 5;

	/** Operation to be performed */
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