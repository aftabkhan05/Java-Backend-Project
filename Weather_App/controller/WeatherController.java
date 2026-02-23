package com.cfs.Weather_App.controller;


import com.cfs.Weather_App.dto.WeatherForeCast;
import com.cfs.Weather_App.dto.WeatherResponse;
import com.cfs.Weather_App.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){


        return weatherService.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city){


        return weatherService.getData(city);
    }

    @GetMapping("/forecast")
        public WeatherForeCast getForecast(@RequestParam String city , @RequestParam int  days){


        return weatherService.getForeCast(city, days);
    }
}
