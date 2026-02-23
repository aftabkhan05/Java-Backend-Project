package com.cfs.Weather_App.dto;

public class Root {
    public Location location;
    public Current current;
    public ForeCast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public ForeCast getForecast() {
        return forecast;
    }

    public void setForecast(ForeCast forecast) {
        this.forecast = forecast;
    }
}
