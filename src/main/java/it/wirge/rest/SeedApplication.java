package it.wirge.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class SeedApplication extends ResourceConfig {

    public SeedApplication(){

        register(new SeedApplicationBinder());
        Set<Class<?>> swaggerClasses = new HashSet();
        swaggerClasses.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        swaggerClasses.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        registerClasses(swaggerClasses);
        packages("it.wirge.rest.endpoints");
    }
}
