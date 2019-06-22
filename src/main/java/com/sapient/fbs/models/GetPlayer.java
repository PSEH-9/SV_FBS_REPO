package com.sapient.fbs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPlayer {

	public String getPlayKey() {
		return playKey;
	}

	public void setPlayKey(String playKey) {
		this.playKey = playKey;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayNumber() {
		return playNumber;
	}

	public void setPlayNumber(String playNumber) {
		this.playNumber = playNumber;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerMatchPlayed() {
		return playerMatchPlayed;
	}

	public void setPlayerMatchPlayed(String playerMatchPlayed) {
		this.playerMatchPlayed = playerMatchPlayed;
	}

	public String getPlayerGoals() {
		return playerGoals;
	}

	public void setPlayerGoals(String playerGoals) {
		this.playerGoals = playerGoals;
	}

	public String getPlayerYellowCards() {
		return playerYellowCards;
	}

	public void setPlayerYellowCards(String playerYellowCards) {
		this.playerYellowCards = playerYellowCards;
	}

	public String getPlayerRedCards() {
		return playerRedCards;
	}

	public void setPlayerRedCards(String playerRedCards) {
		this.playerRedCards = playerRedCards;
	}

	@JsonProperty("player_key")
	private String playKey;

	@JsonProperty("player_name")
	private String playerName;

	@JsonProperty("player_number")
	private String playNumber;

	@JsonProperty("player_country")
	private String playerCountry;

	@JsonProperty("player_type")
	private String playerType;

	@JsonProperty("player_age")
	private String playerAge;

	@JsonProperty("player_match_played")
	private String playerMatchPlayed;

	@JsonProperty("player_goals")
	private String playerGoals;

	@JsonProperty("player_yellow_cards")
	private String playerYellowCards;

	@JsonProperty("player_red_cards")
	private String playerRedCards;

}
