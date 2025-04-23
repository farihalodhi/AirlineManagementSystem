import java.io.*;

public class LoginManager {

    private final String FILE_NAME = "users.txt";
    public boolean Signup(String username, String password) {
        if(userExists(username)){
            System.out.println("User already exists");
            return false;
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))){
            writer.write(username + " ," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Signup failed: " + e.getMessage());
            return false;
        }
    }
    public User Login(String username, String password) {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] credentials = line.split(",");
                if(credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)){
//                    return new User(username,password); //bcs user class is abstract cant make object of it

                }
            }
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        return null;
    }
    private boolean userExists(String username) {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] credentials = line.split(",");
                if(credentials.length > 0 && credentials[0].equals(username)){
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("error in checking if the USER exists: " + e.getMessage());
        }
        return false;
    }
}
