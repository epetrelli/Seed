package it.wirge.rest.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.wirge.rest.models.Beat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.logging.Logger;

@Path("/heartbeat")
@Api(value = "HeartBeat to test api availability")
public class Heartbeat {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @GET
    @Produces("application/vnd.beat-v1+json")
    @ApiOperation(value = "Returns a beat containing current server time", response = Beat.class)
    public Beat getHeartbeat() {
        logger.info("getHeartbeat()");
        Beat beat = new Beat();
        beat.setCurrentTime(System.currentTimeMillis());
        return beat;
    }
}
