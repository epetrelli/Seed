package it.wirge.rest.endpoints;

import io.swagger.annotations.*;
import it.wirge.data.services.ISeedService;
import it.wirge.rest.models.Seed;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@RequestScoped
@Api(value = "Seed endpoint")
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
    @Produces("application/vnd.bean-v1+json")
    @ApiOperation(value = "Finds a Seed by id", response = Seed.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Seed not found"),
            @ApiResponse(code = 500, message = "An error has occurred")
    })
    public Seed getSeed(
            @ApiParam( value = "Seed id (db.seed.idSeed)", required = true )
            @PathParam("id") Long idSeed) {
        logger.info("getSeed(" + idSeed + ")");
        Seed seed = seedService.getSeed(idSeed);
        if (seed != null)
            return seed;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND.getStatusCode());
    }

    @DELETE
    @Path(value = "{id}")
    @ApiOperation(value = "Deletes a seed")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Seed not found"),
            @ApiResponse(code = 500, message = "An error has occurred")
    })
    public void deleteSeed(@ApiParam( value = "Seed id (db.seed.idSeed)", required = true )
                                   @PathParam("id") Long idSeed) {
        logger.info("deleteSeed(" + idSeed + ")");
        Seed seed = seedService.getSeed(idSeed);

        if(seed==null) {
            logger.info("Seed " + idSeed + " not found");
            throw new WebApplicationException(HttpServletResponse.SC_NOT_FOUND);
        }

        try {
            seedService.deleteSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes("application/vnd.bean-v1+json")
    @Produces("application/vnd.bean-v1+json")
    @ApiOperation(value = "Creates a new Seed", response = Seed.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Seed not found"),
            @ApiResponse(code = 500, message = "An error has occurred")
    })
    public Seed insertSeed(Seed seed) {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        Seed seedOut;
        try {
            seedOut = seedService.insertSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return seedOut;
    }

    @PUT
    @Consumes("application/vnd.bean-v1+json")
    @Produces("application/vnd.bean-v1+json")
    @ApiOperation(value = "Saves a new seed", response = Seed.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Seed not found"),
            @ApiResponse(code = 500, message = "An error has occurred")
    })
    public Seed saveSeed(Seed seed) {
        logger.info("saveSeed(" + seed.getIdSeed() + ")");
        Seed seedOut;
        try {
            seedOut = seedService.saveSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return seedOut;
    }
}
