package com.cfs.Weather_App.service;


import com.cfs.Weather_App.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {


    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;


    @Value("${weather.api.forecast.key}")
    private String apiforecastKey;

    @Value("${weather.api.forecast.url}")
    private String apiforecastUrl;


    private RestTemplate template=new RestTemplate();

    public String test() {

        return "App working";
    }

    public WeatherResponse getData(String city) {
        String url = apiUrl + "?key=" + apiKey + "&q=" + city;
        Root response=template.getForObject(url, Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();

        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().name);
        weatherResponse.setCountry(response.getLocation().name);
        String condition=response.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);
        weatherResponse.setTemperature(response.getCurrent().getTemp_c());


        return weatherResponse;
}


    public WeatherForeCast getForeCast(String city, int days) {


        WeatherForeCast weatherForeCast=new WeatherForeCast();
        WeatherResponse weatherResponse =getData(city);
        WeatherForeCast response=new WeatherForeCast();
        weatherForeCast.setWeatherResponse(weatherResponse);
        response.setWeatherResponse(weatherResponse);

        List<DayTemp> dayList=new ArrayList<>();

        String url = apiforecastUrl + "?key=" + apiforecastKey + "&q=" + city +"&days=" +days;
        Root apiresponse=template.getForObject(url, Root.class);
        ForeCast forecast =apiresponse.getForecast();
        ArrayList<ForecastDay>forecastday=forecast.getForecastday();
        for(ForecastDay rs:forecastday) {
            DayTemp d=new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().getMintemp_c());
            d.setAvgTemp(rs.getDay().avgtemp_c);
            d.setMaxTemp(rs.getDay().getMaxtemp_c());
            dayList.add(d);

        }

        response.setDayTemp(dayList);
        return response;







    }
}









