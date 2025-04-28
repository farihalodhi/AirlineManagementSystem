import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    private List<Flight> flights;
    private final String FILE_NAME = "flights.txt";

    public FlightManager() {
        this.flights = new ArrayList<>();
        loadFlightfromFile();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        saveFlightstoFile();
        System.out.println("Flight added successfully: " + flight.getFlightNumber());
    }

    public void viewAvailableFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
    public boolean removeFlight(String flightNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null) {
            flights.remove(flight);
            System.out.println("Flight removed successfully: " + flightNumber);
            return true;
        } else {
            System.out.println("Flight not found: " + flightNumber);
            return false;
        }
    }
    public List<Flight> getFlights() {
        return flights;
    }

    private void saveFlightstoFile() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Flight flight : flights) {
                bw.write(flight.getFlightNumber() + "," + flight.getDepartureCity() + "," +
                        flight.getArrivalCity() + "," + flight.getDepartureTime() + "," + flight.getArrivalTime() + "," + flight.getTotalSeats() + "," + flight.getAvailableSeats());
                bw.newLine();
            }
            System.out.println("Flight saved successfully");
        } catch (IOException e){
            System.out.println("Error saving file: "+e.getMessage());
        }
    }
    private void loadFlightfromFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line = br.readLine()) != null ){
                String[] data = line.split(",");
                if(data.length >= 7){
                    String flightNumber = data[0];
                    String departureCity = data[1];
                    String arrivalCity = data[2];
                    String departureTime = data[3];
                    String arrivalTime = data[4];
                    int totalSeats = Integer.parseInt(data[5]);
                    int availableSeats = Integer.parseInt(data[6]);
                    Flight flight = new Flight(flightNumber,departureCity,arrivalCity,departureTime,arrivalTime,totalSeats,availableSeats,null);
                    flights.add(flight);
                }
            }
            System.out.println("Flight loaded successfully");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error loading flights: " + e.getMessage());
        }
    }
}




