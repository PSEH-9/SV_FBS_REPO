package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class FbsResponse {
	public FbsResponse() {
	}

	public GetCountry getGetCountry() {
		return getCountry;
	}

	public void setGetCountry(GetCountry getCountry) {
		this.getCountry = getCountry;
	}

	public LeagueResponse getGetLeague() {
		return getLeague;
	}

	public void setGetLeague(LeagueResponse getLeague) {
		this.getLeague = getLeague;
	}

	public TeamResponse getGetTeam() {
		return getTeam;
	}

	public void setGetTeam(TeamResponse getTeam) {
		this.getTeam = getTeam;
	}

	public String getLeaguePosition() {
		return leaguePosition;
	}

	public void setLeaguePosition(String leaguePosition) {
		this.leaguePosition = leaguePosition;
	}

	@JsonProperty("country")
	private GetCountry getCountry;

	@JsonProperty("league")
	private LeagueResponse getLeague;

	@JsonProperty("team")
	private TeamResponse getTeam;

	@JsonProperty("leaguePosition")
	private String leaguePosition;
	
	@JsonProperty("errorMsg")
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
