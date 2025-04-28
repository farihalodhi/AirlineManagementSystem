import javax.swing.*;
import java.util.List;
import java.awt.*;

class AirHostessDashboard extends JFrame {

    private JLabel welcomeLabel;
    private JButton scheduleButton, announcementsButton, logoutButton, availabilityButton;
    private FlightManager flightManager;

    public AirHostessDashboard(String username, FlightManager manager) {
        this.flightManager = manager;

        setTitle("Airhostess Dashboard");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        scheduleButton = new JButton("Schedule");
        announcementsButton = new JButton("Announcements");
        availabilityButton = new JButton("Availability");
        logoutButton = new JButton("Logout");

        buttonPanel.add(scheduleButton);
        buttonPanel.add(announcementsButton);
        buttonPanel.add(availabilityButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);

        scheduleButton.addActionListener(e -> {
            List<Flight> flights = flightManager.getFlights();
            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No flights available.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Flight flight : flights) {
                    sb.append("Flight: ").append(flight.getFlightNumber())
                            .append(" | From: ").append(flight.getDepartureCity())
                            .append(" -> To: ").append(flight.getArrivalCity())
                            .append(" | Time: ").append(flight.getDepartureTime())
                            .append("\n");
                }

                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));

                JOptionPane.showMessageDialog(this, scrollPane, "Flight Schedule", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        announcementsButton.addActionListener(e -> {
            String[] announcements = {
                    "Flight A123 delayed due to weather.",
                    "New hygiene guidelines released.",
                    "Uniform inspection at 2:00 PM."
            };
            JTextArea textArea = new JTextArea(String.join("\n", announcements));
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Announcements", JOptionPane.INFORMATION_MESSAGE);
        });


        announcementsButton.addActionListener(e -> {
            String[] announcements = {
                    "Flight A123 delayed by 1 hour.",
                    "New Covid guidelines updated.",
                    "Pilot meeting scheduled at 5 PM."
            };
            JTextArea textArea = new JTextArea(String.join("\n", announcements));
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Announcements", JOptionPane.INFORMATION_MESSAGE);
        });

        availabilityButton.addActionListener(e -> {
            Object[] options = {"Available", "Unavailable"};
            int result = JOptionPane.showOptionDialog(
                    this,
                    "Set your current availability:",
                    "Availability",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (result == JOptionPane.YES_OPTION) {
                showMessage("Status set to: Available");
            } else if (result == JOptionPane.NO_OPTION) {
                showMessage("Status set to: Unavailable");
            }
        });

        logoutButton.addActionListener(e -> {
            showMessage("Logging out...");
            dispose();
            new LoginGUI(flightManager).setVisible(true);
        });

        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
