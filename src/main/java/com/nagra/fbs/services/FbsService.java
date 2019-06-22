package com.nagra.fbs.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.fbs.FbsConfiguration;
import com.sapient.fbs.exceptions.FbsExceptions;
import com.sapient.fbs.models.ErrorFromFBS;
import com.sapient.fbs.models.FbsResponse;
import com.sapient.fbs.models.GetCountry;
import com.sapient.fbs.models.GetLeague;
import com.sapient.fbs.models.GetStanding;
import com.sapient.fbs.models.LeagueResponse;
import com.sapient.fbs.models.TeamResponse;
import com.sapient.fbs.utils.EventType;

public class FbsService {

	private FbsConfiguration fbsConfig;
	private Client client;

	public FbsService(FbsConfiguration fbsConfig, Client client) {
		this.fbsConfig = fbsConfig;
		this.client = client;
	}

	public FbsResponse getFbsResponse(String countryName, String leagueName, String teamName) throws IOException, FbsExceptions {
		Optional<GetCountry> optCountry = getCountry(countryName);
		FbsResponse response = new FbsResponse();

		FbsResponse errorResponse = new FbsResponse();
		if (optCountry.isPresent()) {
			response.setGetCountry(optCountry.get());
		} else {
			errorResponse.setError("Country name doesn't exist");
			return errorResponse;
		}
		
		Optional<GetLeague> optLeague =getLeague(leagueName);
		if(optLeague.isPresent()){
			response.setGetLeague(new LeagueResponse(optLeague.get().getLeagueId(), optLeague.get().getLeagueName()));
		}else{
			errorResponse.setError("League name doesn't exist");
			return errorResponse;
		}
		
		
		Optional<GetStanding> optStanding =getStanding(optLeague.get().getLeagueId());
		if(optStanding.isPresent()){
			response.setLeaguePosition(optStanding.get().getOverall_league_position());
			response.setGetTeam(new TeamResponse(optStanding.get().getTeam_id(), optStanding.get().getTeam_name()));
		}else{
			errorResponse.setError("Overall position doesn't exist");
			return errorResponse;
		}
		
		return response;
	}

	private Optional<GetCountry> getCountry(String countryName) throws IOException, FbsExceptions {
		String baseUrl = fbsConfig.getServiceConfig().getGetEndpoint() + "?action=" + EventType.get_countries
				+ "&APIkey=" + fbsConfig.getServiceConfig().getApiKey();
		WebTarget webtarget = client.target(baseUrl);
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != HttpStatus.OK_200) {
			throw new RuntimeException("Unable to connect to Football Service Server");
		}
		String countriesJson = response.readEntity(String.class);
		if(countriesJson.contains("error")){
			ErrorFromFBS error=new ObjectMapper().readValue(countriesJson, new TypeReference<ErrorFromFBS>(){});
			throw new FbsExceptions(Integer.parseInt(error.getError()),error.getErrorMsg());
		}
		List<GetCountry> countries =new ObjectMapper().readValue(countriesJson, new TypeReference<List<GetCountry>>(){});
		
		return countries.stream()
				.filter(c -> c.getCountryName().equalsIgnoreCase(countryName)).findFirst();
	}
	

	private Optional<GetLeague> getLeague(String leagueName) throws IOException, FbsExceptions {
		String baseUrl = fbsConfig.getServiceConfig().getGetEndpoint() + "?action=" + EventType.get_leagues
				+ "&APIkey=" + fbsConfig.getServiceConfig().getApiKey();
		WebTarget webtarget = client.target(baseUrl);
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != HttpStatus.OK_200) {
			throw new RuntimeException("Unable to connect to Football Service Server");
		}
		String leagueJson = response.readEntity(String.class);
		if(leagueJson.contains("error")){
			ErrorFromFBS error=new ObjectMapper().readValue(leagueJson, new TypeReference<ErrorFromFBS>(){});
			throw new FbsExceptions(Integer.parseInt(error.getError()),error.getErrorMsg());
		}
		List<GetLeague> leagues =new ObjectMapper().readValue(leagueJson, new TypeReference<List<GetLeague>>(){});
		return leagues.stream()
				.filter(l->l.getLeagueName().equalsIgnoreCase(leagueName)).findFirst();
	}
	
	
	private Optional<GetStanding> getStanding(String leagueId) throws IOException, FbsExceptions {
		String baseUrl = fbsConfig.getServiceConfig().getGetEndpoint() + "?action=" + EventType.get_standings
				+ "&league_id="+leagueId+"&APIkey=" + fbsConfig.getServiceConfig().getApiKey();
		WebTarget webtarget = client.target(baseUrl);
		Invocation.Builder invocationBuilder = webtarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() != HttpStatus.OK_200) {
			throw new RuntimeException("Unable to connect to Football Service Server");
		}
		String teamJson = response.readEntity(String.class);
		if(teamJson.contains("error")){
			ErrorFromFBS error=new ObjectMapper().readValue(teamJson, new TypeReference<ErrorFromFBS>(){});
			throw new FbsExceptions(Integer.parseInt(error.getError()),error.getErrorMsg());
		}
		List<GetStanding> teams =new ObjectMapper().readValue(teamJson, new TypeReference<List<GetStanding>>(){});
		return teams.stream()
				.filter(l->l.getLeague_id().equalsIgnoreCase(leagueId)).findFirst();
	}
	
	
}
