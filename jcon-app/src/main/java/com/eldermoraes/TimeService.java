package com.eldermoraes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface TimeService {

    String MSG_ERROR = "we have a problem";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 3000L)
    @Fallback(fallbackMethod = "fallback")
    WorldClock getWorldClock();

    default WorldClock fallback(){
        return new WorldClock(MSG_ERROR);
    }
}
