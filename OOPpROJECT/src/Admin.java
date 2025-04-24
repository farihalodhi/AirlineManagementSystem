package oop_project;

import java.util.List;

public class Admin {
    private FlightManager flightManager;

    public Admin() {
        this.flightManager = new FlightManager();
    }

    public void addFlight(Flight flight) {
        flightManager.getAvailableFlights().add(flight);
    }

    public boolean removeFlight(String flightNumber) {
        return flightManager.getAvailableFlights().removeIf(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }

    public List<Flight> getAllFlights() {
        return flightManager.getAvailableFlights();
    }
}
