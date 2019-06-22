package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCountry {
	@Override
	public String toString() {
		return "GetCountry [countryId=" + countryId + ", countryName=" + countryName + "]";
	}

	public GetCountry() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("country_name")
	private String countryName;

	public String getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}
