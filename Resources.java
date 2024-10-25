package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Config {
    public static String API_KEY;
    public static List<String> CITIES;
    public static int ALERT_THRESHOLD_TEMP;
    public static int POLLING_INTERVAL;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            properties.load(input);

            // Load properties
            API_KEY = properties.getProperty("api.key");
            CITIES = Arrays.asList(properties.getProperty("cities").split(","));
            ALERT_THRESHOLD_TEMP = Integer.parseInt(properties.getProperty("alert.threshold.temp"));
            POLLING_INTERVAL = Integer.parseInt(properties.getProperty("polling.interval"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
