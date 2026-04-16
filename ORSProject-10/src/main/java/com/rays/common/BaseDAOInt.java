package com.rays.common;

import java.util.List;

/**
 * Base DAO interface for CRUD operations and search functionality.
 * 
 * @author Akshat Saxena
 * @param <T> DTO type extending BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/** Adds a new record */
	public long add(T dto ,UserContext userContext);

	/** Updates an existing record */
	public void update(T dto, UserContext userContext);

	/** Deletes a record */
	public void delete(T dto,UserContext userContext);

	/** Finds record by primary key */
	public T findByPk(long id, UserContext userContext);

	/** Finds record by unique key attribute */
	public T findByUniqueKey(String attribute, Object value, UserContext userContext);

	/** Searches records with pagination */
	public List search(T dto, int pageNo, int pageSize , UserContext userContext);

	/** Searches all matching records */
	public List search(T dto , UserContext userContext);

}