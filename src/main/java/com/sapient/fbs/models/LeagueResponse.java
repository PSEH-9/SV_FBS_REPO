package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeagueResponse {
	
 public LeagueResponse(String leagueId,String leagueName) {
	 this.leagueId=leagueId;
	 this.leagueName=leagueName;
	}
	@JsonProperty("league_id")
	private String leagueId;
	@JsonProperty("league_name")
	private String leagueName;

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
}
