package com.eldermoraes;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.sql.Time;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    TimeService timeService;

    @Override
    public HealthCheckResponse call() {
        if (timeService.getWorldClock().getDatetime().equals(TimeService.MSG_ERROR)){
            return HealthCheckResponse.down("I'm not ready");
        } else{
            return HealthCheckResponse.up("I'm  ready");
        }
    }
}
