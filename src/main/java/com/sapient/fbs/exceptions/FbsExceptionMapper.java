package com.sapient.fbs.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class FbsExceptionMapper implements ExceptionMapper<FbsExceptions> {

	@Override
	public Response toResponse(FbsExceptions exception) {
		 return Response.status(exception.getCode())
	                .entity(exception.getMessage())
	                .type(MediaType.APPLICATION_JSON)
	                .build();
	}

}
