package it.wirge.rest.endpoints;

import it.wirge.rest.models.Beat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/heartbeat")
public class Heartbeat {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beat getHeartbeat() {
        Beat beat = new Beat();
        beat.setCurrentTime(System.currentTimeMillis());
        return beat;
    }
}
