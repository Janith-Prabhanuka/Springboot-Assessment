package com.bwap.weatherapp.WeatherApp;

import com.bwap.weatherapp.WeatherApp.controller.WeatherService;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WeatherAppApplicationTests {

	@Autowired
	private WeatherService weatherService;

	@Test
	public void contextLoads() {
	}

	@Test
	void getWeatherTest() {
		JSONObject weather = weatherService.getWeather("10.50", "50.50");
		Assertions.assertNotNull(weather);
	}

}
