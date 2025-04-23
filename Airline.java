package oop_project;

import java.util.List;

public class Airline {
    protected String airlineName;
    protected List<Flight> flights;

    public Airline(String airlineName, List<Flight> flights) {
        this.airlineName = airlineName;
        this.flights = flights;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
