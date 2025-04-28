import java.io.*;

public class LoginManager {
    private final String FILE_NAME = "users.txt";

    public boolean Signup(String username, String password,String role) {
        if (userExists(username)) {
            System.out.println("User already exists");
            return false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + " ," + password+ ", "+role);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Signup failed: " + e.getMessage());
            return false;
        }
    }

    public User Login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 3 && credentials[0].trim().equals(username) && credentials[1].trim().equals(password)) {
                    String role = credentials[2].trim();
                    switch (role.toUpperCase()) {
                        case "PILOT":
                            return new Pilot(username, password);
                        case "PASSENGER":
                            return new Passenger(username, password);
                        case "AIRHOSTESS" :
                            return new AirHostess(username, password);
                        case "ADMIN":
                            return new Admin(username,password,role);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return null;
    }

    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length > 0 && credentials[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("error in checking if the USER exists: " + e.getMessage());
        }
        return false;
    }
}

