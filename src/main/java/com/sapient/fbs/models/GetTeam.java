package com.sapient.fbs.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTeam {

	@JsonProperty("team_key")
	private String teamKey;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("team_badge")
	private String teamBadge;

	public String getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamBadge() {
		return teamBadge;
	}

	public void setTeamBadge(String teamBadge) {
		this.teamBadge = teamBadge;
	}

	public List<GetPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<GetPlayer> players) {
		this.players = players;
	}

	@JsonProperty("players")
	private List<GetPlayer> players;

}
