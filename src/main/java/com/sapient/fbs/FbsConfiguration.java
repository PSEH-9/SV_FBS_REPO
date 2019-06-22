package com.sapient.fbs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class FbsConfiguration extends Configuration {

	@NotNull
	@Valid
	private FbsServiceConfiguration serviceConfig;

	@JsonProperty("fbsService")
	public FbsServiceConfiguration getServiceConfig() {
		return serviceConfig;
	}

	public void setServiceConfig(FbsServiceConfiguration serviceConfig) {
		this.serviceConfig = serviceConfig;
	}
	
}
