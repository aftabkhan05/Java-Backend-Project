package com.cfs.Weather_App.dto;

import java.util.ArrayList;

public class ForeCast {
    public ArrayList<ForecastDay> forecastday;

    public ArrayList<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(ArrayList<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }
}
