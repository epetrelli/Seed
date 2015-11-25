package it.wirge.rest;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class SeedApplication extends ResourceConfig {

    public SeedApplication(){

        register(new SeedApplicationBinder());
        packages("it.wirge.rest.endpoints");

        //Swagger setup
        Set<Class<?>> swaggerClasses = new HashSet();
        swaggerClasses.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        swaggerClasses.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        registerClasses(swaggerClasses);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("it.wirge.rest.endpoints");
        beanConfig.setScan(true);
    }
}
