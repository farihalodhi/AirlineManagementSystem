import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Failed to set look and feel: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            FlightManager flightManager = new FlightManager();
            new LoginGUI(flightManager).setVisible(true);
        });
    }
}
