import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton guestButton;
    private JLabel statusLabel;
    private JComboBox<String> roleDropdown;
    private FlightManager flightManager;
    private JButton signupButton;

    public LoginGUI(FlightManager manager) {
        this.flightManager = manager;
        LoginManager loginManager = new LoginManager();

        setTitle("Airline Management System - Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 10, 50));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Select Role:"));
        roleDropdown = new JComboBox<>(new String[]{"Pilot", "AirHostess", "Admin"});
        panel.add(roleDropdown);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        signupButton = new JButton("Sign Up");
        panel.add(signupButton);

        guestButton = new JButton("Continue as Guest");
        panel.add(guestButton);

        statusLabel = new JLabel("");
        panel.add(statusLabel);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String selectedRole = (String) roleDropdown.getSelectedItem();

                User user = loginManager.Login(username, password);

                if (user == null) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid credentials or user doesn't exist");
                    return;
                }

                switch (selectedRole) {
                    case "Pilot":
                        if (user instanceof Pilot) {
                            new PilotDashboard(((Pilot) user).getUsername(),flightManager).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect role selected for this user.");
                            return;
                        }
                        break;
                    case "AirHostess":
                        if (user instanceof AirHostess) {
                            new AirHostessDashboard(user.getUsername(),flightManager).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect role selected for this user.");
                            return;
                        }
                        break;
                    case "Admin":
                        if (user instanceof Admin) {
                            new AdminDashboard(user.getUsername(),flightManager).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect role selected for this user.");
                            return;
                        }
                        break;
                }

                dispose();
            }
        });

        guestButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(LoginGUI.this, "Welcome Guest!");
            new GuestView(flightManager).setVisible(true);
            dispose();
        });
        signupButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String selectedRole = (String) roleDropdown.getSelectedItem();

            if (username.isEmpty() || password.isEmpty() || selectedRole.isEmpty()) {
                JOptionPane.showMessageDialog(LoginGUI.this, "Please fill all fields.");
                return;
            }

            if (!selectedRole.equalsIgnoreCase("Pilot") &&
                    !selectedRole.equalsIgnoreCase("AirHostess") &&
                    !selectedRole.equalsIgnoreCase("Admin")) {
                JOptionPane.showMessageDialog(LoginGUI.this, "Invalid role. Only Pilot, AirHostess, or Admin can signup.");
                return;
            }

            if (loginManager.Signup(username, password, selectedRole)) {
                JOptionPane.showMessageDialog(LoginGUI.this, "Signup successful! You can now login.");
            } else {
                JOptionPane.showMessageDialog(LoginGUI.this, "Signup failed. Username might already exist.");
            }
        });
    }
}
