package com.eldermoraes;

public class WorldClock {

    private String datetime;

    public WorldClock(String datetime) {
        this.datetime = datetime;
    }

    public WorldClock() {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
