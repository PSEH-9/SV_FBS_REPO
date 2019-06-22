package com.sapient.fbs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FbsServiceConfiguration {

	@JsonProperty("endpoint")
	private String getEndpoint;
	
	@JsonProperty("apikey")
	private String apiKey;

	public String getGetEndpoint() {
		return getEndpoint;
	}

	public void setGetEndpoint(String getEndpoint) {
		this.getEndpoint = getEndpoint;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
