import javax.swing.*;
import java.awt.*;

public class Airhostess extends JFrame {

    private JLabel welcomeLabel;
    private JButton scheduleButton, announcementsButton, logoutButton, availabilityButton;

    public Airhostess(String username) {
        // Set up the frame
        setTitle("Airhostess Dashboard");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout());

        // Welcome label
        welcomeLabel = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(welcomeLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Load icons (optional: only if you have image files)
        ImageIcon scheduleIcon = new ImageIcon("src/icons/schedule.png");
        ImageIcon announcementsIcon = new ImageIcon("src/icons/announcements.png");
        ImageIcon logoutIcon = new ImageIcon("src/icons/logout.png");

        // Create buttons with or without icons
        scheduleButton = new JButton("Schedule", scheduleIcon);
        announcementsButton = new JButton("Announcements", announcementsIcon);
        availabilityButton = new JButton("Availability"); // New button
        logoutButton = new JButton("Logout", logoutIcon);

        // Button text/icon alignment
        scheduleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        scheduleButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        announcementsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        announcementsButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        logoutButton.setHorizontalTextPosition(SwingConstants.CENTER);
        logoutButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        availabilityButton.setHorizontalTextPosition(SwingConstants.CENTER);
        availabilityButton.setVerticalTextPosition(SwingConstants.BOTTOM);

        // Add buttons to panel
        buttonPanel.add(scheduleButton);
        buttonPanel.add(announcementsButton);
        buttonPanel.add(availabilityButton);
        buttonPanel.add(logoutButton);

        // Add panel to frame
        add(buttonPanel, BorderLayout.CENTER);

        // Action listeners
        scheduleButton.addActionListener(e -> showMessage("Opening flight schedule..."));
        announcementsButton.addActionListener(e -> showMessage("Fetching announcements..."));

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
            dispose(); // Close current window
            new LoginGUI(); // Go back to login screen
        });

        setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Main method for standalone testing
    public static void main(String[] args) {
        new Airhostess("Airhostess");
    }
}
