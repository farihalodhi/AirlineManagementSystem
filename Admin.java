import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<Flight> availableFlights;

    public Admin(String username, String password, String role) {
        super(username, password, role);
        this.availableFlights = new ArrayList<>();
        addSampleFlights();
    }

    public Admin() {
        super("admin", "admin123", "Admin");
        this.availableFlights = new ArrayList<>();
        addSampleFlights();
    }
    public void addFlight(Flight newflight) {
        availableFlights.add(newflight);
    }

    public void addSampleFlights() {
        availableFlights.add(new Flight("A123", "Karachi", "Lahore", "2025-04-25 10:00", "50", 456, 450,
                new Pilot("Captain Faizan", "abc23", "12345", new ArrayList<>())));
        availableFlights.add(new Flight("B456", "Karachi", "Islamabad", "2025-04-25 15:00", "100", 567, 500,
                new Pilot("Captain Me", "45rcgg", "op90nb", new ArrayList<>())));
    }

    public List<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public boolean bookFlight(Flight flight) {
        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            System.out.println("Flight has been booked. Seats left: " + flight.getAvailableSeats());
            return true;
        }
        return false;
    }

    public boolean removeFlight(String flightNumber) {
        return availableFlights.removeIf(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(availableFlights);
    }
}
