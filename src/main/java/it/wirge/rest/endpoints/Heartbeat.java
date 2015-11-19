package it.wirge.rest.endpoints;

import it.wirge.data.dao.SeedDao;
import it.wirge.data.entites.Seed;
import it.wirge.rest.models.Beat;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@Path("/heartbeat")
public class Heartbeat {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private SeedDao seedDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beat getHeartbeat() {
        logger.info("getHeartbeat()");
        Beat beat = new Beat();
        beat.setCurrentTime(System.currentTimeMillis());

        List<Seed> seeds = seedDao.getSeeds();

        logger.info(seeds.size() + " seeds");


        return beat;
    }
}
