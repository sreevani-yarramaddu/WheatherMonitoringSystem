package model;

public class WeatherData {
    private String city;
    private double temperature;
    private String mainCondition;
    private long timestamp;

    public WeatherData(String city, double temperature, String mainCondition, long timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.mainCondition = mainCondition;
        this.timestamp = timestamp;
    }

    public String getCity() { return city; }
    public double getTemperature() { return temperature; }
    public String getMainCondition() { return mainCondition; }
    public long getTimestamp() { return timestamp; }
}
