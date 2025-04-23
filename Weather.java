package oop_project;

public class Weather {
    protected String location;
    protected String forecast;
    protected String temperature;
    protected String humidity;

    public Weather(String location, String forecast, String temperature, String humidity) {
        this.location = location;
        this.forecast = forecast;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
