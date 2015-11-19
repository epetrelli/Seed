package it.wirge.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class SeedApplication extends ResourceConfig {

    public SeedApplication(){

        register(new SeedApplicationBinder());
        packages("it.wirge.rest.endpoints");

    }

}
