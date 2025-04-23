package oop_project;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
public class Flight {
    protected String flightNumber;
    protected String sourceAirport;
    protected String destinationAirport;
    protected LocalTime departureTime;
    protected LocalDate arrivalTime;
    protected List<Seat> seats;
    protected String status; //On time, delayed, cancelled
    //protected Pilot assignedPilot;
    //protected List<AirHostess> assignedHostess;
    private Weather weatherForecast;

    public Flight(String flightNumber, String sourceAirport, String destinationAirport, LocalTime departureTime, LocalDate arrivalTime, List<Seat> seats, String status, Weather weatherForecast) {
        this.flightNumber = flightNumber;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.status = status;
        this.weatherForecast = weatherForecast;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getStatus() {
        return status;
    }

    public Weather getWeatherForecast() {
        return weatherForecast;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWeatherForecast(Weather weatherForecast) {
        this.weatherForecast = weatherForecast;
    }
}
