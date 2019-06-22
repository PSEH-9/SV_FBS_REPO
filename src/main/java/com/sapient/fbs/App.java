package com.sapient.fbs;

import javax.ws.rs.client.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagra.fbs.resources.FootballServiceResources;
import com.nagra.fbs.services.FbsService;
import com.sapient.fbs.exceptions.FbsExceptionMapper;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App  extends Application<FbsConfiguration> {
	 private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	 
	    @Override
	    public void initialize(Bootstrap<FbsConfiguration> b) {
	    	 b.setConfigurationSourceProvider(
	                 new SubstitutingSourceProvider(b.getConfigurationSourceProvider(),
	                                                    new EnvironmentVariableSubstitutor(false)
	                 )
	         );	    }
	 
	    @Override
	    public void run(FbsConfiguration c, Environment e) throws Exception {
	    	final Client client = new JerseyClientBuilder(e).build("Fbs");
	        LOGGER.info("Registering REST resources");
	        e.jersey().register(new FbsExceptionMapper());
	        e.jersey().register(new FootballServiceResources(new FbsService(c,client)));
	    }
	 
	    public static void main(String[] args) throws Exception {
	        new App().run(args);
	    }

}
