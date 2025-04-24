package oop_project;

import java.util.List;

public class AirHostess implements Scheduled{
    private List<Flight> flights;

    public AirHostess(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public void viewSchedule() {
        for (Flight f : flights) {
            System.out.println(f.toString());
        }
    }

    @Override
    public void markAvailability() {

    }

    public List<Flight> getAssignedFlights() {
        return flights;
    }

    public void setAssignedFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
