import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PassengerDashboard extends JFrame {
    private JLabel welcomeLabel;
    private JButton bookFlightButton;
    private JButton viewBookingsButton;
    private JButton viewScheduleButton;
    private JButton logoutButton;
    private FlightManager flightManager;
    private List<Flight> availableFlights;

    public PassengerDashboard(String passengerName) {
        flightManager = new FlightManager(); // Initialize flight manager
        availableFlights = flightManager.getAvailableFlights(); // Get available flights

        setTitle("Passenger Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(40, 75, 99));
        welcomeLabel = new JLabel("Welcome Passenger, " + passengerName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        buttonPanel.setBackground(new Color(220, 230, 240));

        bookFlightButton = new JButton("Book New Flight");
        viewBookingsButton = new JButton("View My Bookings");
        viewScheduleButton = new JButton("View Flight Schedule");
        logoutButton = new JButton("Logout");

        buttonPanel.add(bookFlightButton);
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(logoutButton);

        // Add listeners
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose(); // close dashboard
            new LoginGUI().setVisible(true); // go back to login
        });

        // Book Flight Button Action
        bookFlightButton.addActionListener(e -> {
            // Show available flights to book
            String[] flightOptions = availableFlights.stream()
                    .map(f -> f.getFlightId() + " - " + f.getSource() + " to " + f.getDestination())
                    .toArray(String[]::new);

            String flightChoice = (String) JOptionPane.showInputDialog(this, "Choose a flight to book:",
                    "Flight Booking", JOptionPane.QUESTION_MESSAGE, null, flightOptions, flightOptions[0]);

            if (flightChoice != null) {
                String flightId = flightChoice.split(" - ")[0];
                Flight chosenFlight = availableFlights.stream()
                        .filter(f -> f.getFlightId().equals(flightId))
                        .findFirst().orElse(null);

                if (chosenFlight != null && flightManager.bookFlight(chosenFlight)) {
                    JOptionPane.showMessageDialog(this, "Flight booked successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sorry, no seats available.");
                }
            }
        });

        // View Bookings Button Action
        viewBookingsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Viewing my bookings..."));

        // View Schedule Button Action
        viewScheduleButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Viewing flight schedule..."));

        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PassengerDashboard("Fariha").setVisible(true); // Test with passenger name
        });
    }
}
