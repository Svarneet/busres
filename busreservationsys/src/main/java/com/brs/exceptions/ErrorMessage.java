package com.brs.exceptions;

public class ErrorMessage {
	private Integer errorCode;
	private String errorMsg;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMsg;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMsg = errorMessage;
	}

}