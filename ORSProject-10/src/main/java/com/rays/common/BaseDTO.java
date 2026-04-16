package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base DTO class providing common fields and audit trail functionality.
 * 
 * @author Akshat Saxena
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

	/** Primary key ID */
	@Id
	@GeneratedValue(generator = "pk")
	@GenericGenerator(name = "pk", strategy = "native")
	@Column(name = "ID", nullable = false, unique = true)
	protected Long id;

	/** User who created the record */
	@Column(name = "CREATED_BY", length = 50)
	protected String createdBy;

	/** User who last modified the record */
	@Column(name = "MODIFIED_BY", length = 50)
	protected String modifiedBy;

	/** Record creation timestamp */
	@Column(name = "CREATED_DATETIME")
	protected Timestamp createdDateTime;

	/** Last modification timestamp */
	@Column(name = "MODIFIED_DATETIME")
	protected Timestamp modifiedDateTime;
	
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	

	public abstract String getUniqueKey();

	public abstract String getUniqueValue();

	public abstract String getLabel();

	public abstract String getTableName();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}


	@Override
	public String toString() {
		return "BaseDTO [id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime="
				+ createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}
	
	

}