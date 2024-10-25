package config;

import java.util.List;
import java.util.Arrays;

public class Config {
    public static final String API_KEY = "your_api_key_here";
    public static final List<String> CITIES = Arrays.asList("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad");
    public static final int ALERT_THRESHOLD_TEMP = 35; // Celsius
    public static final int POLLING_INTERVAL = 5 * 60 * 1000; // 5 minutes in milliseconds
}

