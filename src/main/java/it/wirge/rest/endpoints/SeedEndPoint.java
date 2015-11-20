package it.wirge.rest.endpoints;

import it.wirge.data.entities.Seed;
import it.wirge.data.services.ISeedService;
import it.wirge.data.services.SeedService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


@Path("/seed")
public class SeedEndPoint {

    Logger logger = Logger.getLogger(this.getClass().getName());

    private final ISeedService seedService;

    @Inject
    public SeedEndPoint(ISeedService seedService) {
        this.seedService = seedService;
    }

    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Seed getSeed(@PathParam("id") int idSeed) {
        logger.info("getSeed(" + idSeed + ")");
        return seedService.getSeed(idSeed);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSeed(Seed seed) {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
        seedService.deleteSeed(seed);
        return Response.status(Response.Status.OK).entity("Seed has been successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveSeed(Seed seed){
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        seedService.saveSeed(seed);
        return Response.status(Response.Status.OK).entity("Seed has been successfully saved").type(MediaType.APPLICATION_JSON).build();
    }
}
