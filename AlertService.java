package service;

import config.Config;
import model.WeatherData;

public class AlertService {

    private int alertCounter = 0;

    public void checkAlertCondition(WeatherData data) {
        if (data.getTemperature() > Config.ALERT_THRESHOLD_TEMP) {
            alertCounter++;
            if (alertCounter >= 2) {
                System.out.println("ALERT: High temperature in " + data.getCity() + ": " + data.getTemperature() + "°C");
                alertCounter = 0; // Reset after alert
            }
        } else {
            alertCounter = 0;
        }
    }
}
