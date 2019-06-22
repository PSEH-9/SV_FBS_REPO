package com.nagra.fbs.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;
import org.hibernate.validator.constraints.NotEmpty;

import com.nagra.fbs.services.FbsService;
import com.sapient.fbs.exceptions.FbsExceptions;
import com.sapient.fbs.models.FbsResponse;

@Path("/fbs")
@Produces(MediaType.APPLICATION_JSON)
public class FootballServiceResources {
	private final FbsService service;

	public FootballServiceResources(FbsService service) {
		this.service = service;
	}

	@GET
	@Path("/standingteam")
	public Response getStandingTeam(@QueryParam("countryName")  @NotEmpty String countryName,
			@NotEmpty @QueryParam("leagueName") String leagueName,  @NotEmpty @QueryParam("teamName") String teamName) throws IOException, FbsExceptions {
		FbsResponse response = service.getFbsResponse(countryName, leagueName, teamName);
		if (response.getError() != null && !response.getError().isEmpty()) {
			Response.status(HttpStatus.BAD_REQUEST_400).entity(response).build();
		}
		return Response.ok(response).build();
	}
}
