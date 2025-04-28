import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssignedFlightManager {
    private final String FILE_NAME = "assignedFlights.txt";

    public void assignFlightToUser(String role, String username, String flightNumber) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(role + "," + username + "," + flightNumber);
            bw.newLine();
            System.out.println("Assignment saved: " + role + ", " + username + ", " + flightNumber);
        } catch (IOException e) {
            System.out.println("Error assigning flight: " + e.getMessage());
        }
    }

    public List<String> getAssignedFlights(String role, String username) {
        List<String> assignedFlights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String fileRole = parts[0].trim();
                    String fileUsername = parts[1].trim();
                    String flightNumber = parts[2].trim();

                    if (fileRole.equalsIgnoreCase(role) && fileUsername.equalsIgnoreCase(username)) {
                        assignedFlights.add(flightNumber);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Assignment file not found. No assignments yet.");
        } catch (IOException e) {
            System.out.println("Error loading assigned flights: " + e.getMessage());
        }
        return assignedFlights;
    }

    // (Optional) Load all assignments (for Admin view maybe later)
    public List<String> loadAllAssignments() {
        List<String> allAssignments = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                allAssignments.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading all assignments: " + e.getMessage());
        }
        return allAssignments;
    }
}
