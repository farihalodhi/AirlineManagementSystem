import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    private List<Flight> availableFlights;

    public FlightManager() {
        this.availableFlights = new ArrayList<>();
        // Adding sample flights
        availableFlights.add(new Flight("A123", "Karachi", "Lahore", "2025-04-25 10:00", "50",456,450,new Pilot("captsin faizan","abc23","12345",getAvailableFlights())));
        availableFlights.add(new Flight("B456", "Karachi", "Islamabad", "2025-04-25 15:00", "100",567,500,new Pilot("captain me","45rcgg","op90nb",getAvailableFlights())));
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public boolean bookFlight(Flight flight) {
        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            return true;
        }
        return false; // If no available seats
    }
}
