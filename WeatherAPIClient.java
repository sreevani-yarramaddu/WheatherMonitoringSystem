package service;

import config.Config;
import model.WeatherData;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPIClient {

    public WeatherData fetchWeatherData(String city) throws Exception {
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + Config.API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        JSONObject json = new JSONObject(inline.toString());
        double tempInKelvin = json.getJSONObject("main").getDouble("temp");
        double tempInCelsius = TemperatureConverter.kelvinToCelsius(tempInKelvin);
        String mainCondition = json.getJSONArray("weather").getJSONObject(0).getString("main");
        long timestamp = json.getLong("dt");

        return new WeatherData(city, tempInCelsius, mainCondition, timestamp);
    }
}
