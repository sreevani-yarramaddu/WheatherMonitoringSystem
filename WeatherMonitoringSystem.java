import config.Config;
import model.WeatherData;
import service.AlertService;
import service.DataProcessor;
import service.WeatherAPIClient;

public class WeatherMonitoringSystem {

    private WeatherAPIClient apiClient = new WeatherAPIClient();
    private DataProcessor dataProcessor = new DataProcessor();
    private AlertService alertService = new AlertService();

    public void runSystem() {
        while (true) {
            try {
                for (String city : Config.CITIES) {
                    WeatherData data = apiClient.fetchWeatherData(city);
                    dataProcessor.processWeatherData(data);
                    alertService.checkAlertCondition(data);
                    System.out.println("Fetched data for " + city + ": " + data.getTemperature() + "°C");
                }
                System.out.println("Daily Average Temperatures: " + dataProcessor.calculateAverageTemperature());
                Thread.sleep(Config.POLLING_INTERVAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WeatherMonitoringSystem system = new WeatherMonitoringSystem();
        system.runSystem();
    }
}
