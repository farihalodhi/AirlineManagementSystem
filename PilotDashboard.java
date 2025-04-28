import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PilotDashboard extends JFrame {
    private JLabel welcomeLabel;
    private JButton viewScheduleButton;
    private JButton assignedFlightsButton;
    private JButton logoutButton;
    private FlightManager flightManager;

    public PilotDashboard(String pilotName,FlightManager manager) {
        this.flightManager = manager;
        setTitle("Pilot Dashboard - " + pilotName);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(40, 75, 99));
        welcomeLabel = new JLabel("Welcome, Captain " + pilotName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        buttonPanel.setBackground(new Color(220, 230, 240));

        assignedFlightsButton = new JButton("View Assigned Flights");
        viewScheduleButton = new JButton("View Schedule");
        logoutButton = new JButton("Logout");

        buttonPanel.add(assignedFlightsButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(logoutButton);

        // Action Listeners
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
            new LoginGUI(flightManager).setVisible(true);
        });

        assignedFlightsButton.addActionListener(e -> {
            String pilotUsername = welcomeLabel.getText().replace("Welcome, Captain ", "").trim();
            List<String> assignedFlightNumbers = AssignmentManager.getAssignedFlightsForPilot(pilotUsername);

            if (assignedFlightNumbers.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No assigned flights found for you.");
            } else {
                StringBuilder sb = new StringBuilder("Your Assigned Flights:\n\n");
                for (String flightNum : assignedFlightNumbers) {
                    sb.append("Flight Number: ").append(flightNum).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            }
        });
        viewScheduleButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Showing schedule..."));

        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

}
