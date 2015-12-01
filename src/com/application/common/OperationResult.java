package com.application.common;

import com.application.constants.AppConstants;

public class OperationResult {
	
	private String status;
	private String errorMessage;
	
	public OperationResult() {
		status = AppConstants.NONE;
		errorMessage = AppConstants.EMPTY_STRING;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setSuccess() {
		this.status = AppConstants.SUCCESS;
		this.errorMessage = AppConstants.EMPTY_STRING;
	}
	
	public void setError(String errorMessage) {
		this.status = AppConstants.ERROR;
		this.errorMessage = errorMessage;
	}
}
