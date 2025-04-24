import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {


    //Continue as a guest option

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginGUI() {
        // Set up the frame
        setTitle("Airline Management System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Create a panel for the form
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 10, 50));

        // Username
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        panel.add(loginButton);

        // Status label
        statusLabel = new JLabel("");
        panel.add(statusLabel);

        add(panel, BorderLayout.CENTER);

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Dummy authentication logic
        if (username.equals("admin") && password.equals("password")) {
            statusLabel.setText("Login successful!");
            JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
            // Proceed to dashboard or next window here
        } else {
            statusLabel.setText("Invalid credentials.");
            JOptionPane.showMessageDialog(this, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new LoginGUI();
    }
}
