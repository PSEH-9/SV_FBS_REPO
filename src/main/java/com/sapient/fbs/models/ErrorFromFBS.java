package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorFromFBS {
	@JsonProperty("error")
	private String error;
	
	@JsonProperty("message")
	private String errorMsg;

	public ErrorFromFBS() {
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
