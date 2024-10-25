package service;

import model.WeatherData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProcessor {

    private Map<String, List<WeatherData>> dailyData = new HashMap<>();

    public void processWeatherData(WeatherData data) {
        dailyData.computeIfAbsent(data.getCity(), k -> new java.util.ArrayList<>()).add(data);
    }

    public Map<String, Double> calculateAverageTemperature() {
        Map<String, Double> averages = new HashMap<>();
        for (Map.Entry<String, List<WeatherData>> entry : dailyData.entrySet()) {
            double avgTemp = entry.getValue().stream().mapToDouble(WeatherData::getTemperature).average().orElse(0.0);
            averages.put(entry.getKey(), avgTemp);
        }
        return averages;
    }
}
