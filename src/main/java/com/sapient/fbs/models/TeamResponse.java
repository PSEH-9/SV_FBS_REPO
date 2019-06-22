package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamResponse {
	
	
	
	public TeamResponse(String teamId,String teamName) {
		this.teamName = teamName;
		this.teamId = teamId;
	}

	@JsonProperty("team_name")
	private String teamName;
	
	@JsonProperty("team_id")
	private String teamId;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

}
