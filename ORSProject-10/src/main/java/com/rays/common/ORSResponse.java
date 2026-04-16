package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Response wrapper class for API responses.
 * 
 * @author Akshat Saxena
 */
public class ORSResponse {

	public static final String INPUT_ERROR = "inputerror";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";

	private boolean success = false;

	private Map<String, Object> result = new HashMap<String, Object>();
	
	/** Default constructor */
	public ORSResponse(){
		
	}
	
	/** Constructor with success flag */
	public ORSResponse(boolean success) {
		this.success = success;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/** Adds message to response */
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

	/** Adds input error to response */
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

	/** Adds data to response */
	public void addData(Object value) {
		result.put(DATA, value);

	}

	/** Adds custom key-value pair to result */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}

	@Override
	public String toString() {
		return "ORSResponse [success=" + success + ", result=" + result + "]";
	}
}