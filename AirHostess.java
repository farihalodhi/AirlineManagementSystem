
import java.util.List;

public class AirHostess extends User implements Schedulabale{
    private List<Flight> flights;
    public AirHostess(String username, String password) {
        super(username, password);
    }

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