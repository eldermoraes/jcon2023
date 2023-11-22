package com.eldermoraes;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;

@Path("/jcon")
@RunOnVirtualThread
public class TimeResource {

    @RestClient
    TimeService timeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String time() {
        System.out.println(Thread.currentThread());

        return timeService.getWorldClock().getDatetime() + "\n";
    }
}
