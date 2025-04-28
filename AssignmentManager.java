import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {
    private static final String FILE_NAME = "assignedFlights.txt";

    public static void assignFlightToPilot(String pilotUsername, String flightNumber) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(pilotUsername.trim() + "," + flightNumber.trim());
            bw.newLine();
            System.out.println(" Flight " + flightNumber + " assigned to " + pilotUsername);
        } catch (IOException e) {
            System.out.println("Error assigning flight: " + e.getMessage());
        }
    }

    public static List<String> getAssignedFlightsForPilot(String pilotUsername) {
        List<String> assignedFlights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2 && data[0].trim().equalsIgnoreCase(pilotUsername.trim())) {
                    assignedFlights.add(data[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading assigned flights: " + e.getMessage());
        }
        return assignedFlights;
    }
}
