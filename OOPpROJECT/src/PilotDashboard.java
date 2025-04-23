import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilotDashboard extends JFrame {

    private JLabel welcomeLabel;
    private JButton viewScheduleButton;
    private JButton assignedFlightsButton;
    private JButton logoutButton;

    public PilotDashboard(String pilotName) {
        setTitle("Pilot Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(40, 75, 99));
        welcomeLabel = new JLabel("Welcome Pilot, " + pilotName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
        buttonPanel.setBackground(new Color(220, 230, 240));

        assignedFlightsButton = new JButton("View Assigned Flights");
        viewScheduleButton = new JButton("View Schedule");
        logoutButton = new JButton("Logout");

        buttonPanel.add(assignedFlightsButton);
        buttonPanel.add(viewScheduleButton);
        buttonPanel.add(logoutButton);

        // Add listeners
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose(); // close dashboard
            new LoginGUI().setVisible(true); // go back to login
        });

        // Placeholder actions
        assignedFlightsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Showing assigned flights..."));
        viewScheduleButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Showing schedule..."));

        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        // Create a dummy pilot name for testing
        SwingUtilities.invokeLater(() -> {
            new PilotDashboard("Captain Ayesha").setVisible(true);
        });
    }

}
