package it.wirge.rest.endpoints;

import it.wirge.data.services.ISeedService;
import it.wirge.rest.models.Seed;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.http.HTTPException;
import java.util.logging.Logger;

@RequestScoped
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
        Seed seed = seedService.getSeed(idSeed);
        if(seed!=null)
            return seedService.getSeed(idSeed);
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND.getStatusCode());
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteSeed(Seed seed) {
        logger.info("deleteSeed(" + seed.getIdSeed() + ")");
        try {
            seedService.deleteSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return Response.status(Response.Status.OK).entity("Seed has been successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Seed insertSeed(Seed seed){
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        try {
            seedService.insertSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return seed;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Seed saveSeed(Seed seed){
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        try {
            seedService.saveSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return seed;
    }
}
