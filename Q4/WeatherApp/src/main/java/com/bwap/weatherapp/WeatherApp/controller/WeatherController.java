package com.bwap.weatherapp.WeatherApp.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/weather")

public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("")
    public String getWeather(
            @RequestParam(value = "latitude" ,required = false) String latitude,
            @RequestParam(value = "longitude" ,required = false) String longitude
    ){
        return weatherService.getWeather(latitude,longitude).toString();
    }



}
