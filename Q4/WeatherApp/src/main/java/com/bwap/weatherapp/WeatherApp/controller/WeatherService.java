package com.bwap.weatherapp.WeatherApp.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class WeatherService {
    private OkHttpClient client;
    private Response response;

    String unit;
    private String API = "8d5058ee97228cbe18afd9c9326b5f71";


    public JSONObject getWeather(String latitude,String longitude) {
        client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.openweathermap.org/data/2.5/weather?lon=" + longitude + "&lat=" + latitude + "&appid=8d5058ee97228cbe18afd9c9326b5f71").build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}