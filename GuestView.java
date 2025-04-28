import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestView extends JFrame {

    private FlightManager flightManager;
    private Passenger guestPassenger;
    private JTextArea outputArea;
    private JTextField flightField;
    private JButton viewFlightsButton, bookFlightButton, viewMyBookingsButton, backButton;

    public GuestView(FlightManager manager) {
        this.flightManager = manager;
        this.guestPassenger = new Passenger("GuestUser", "guest123"); // dummy guest

        setTitle("Guest View - Airline Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter Flight Number to Book:"));
        flightField = new JTextField(15);
        topPanel.add(flightField);
        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        viewFlightsButton = new JButton("View Available Flights");
        bookFlightButton = new JButton("Book Flight");
        viewMyBookingsButton = new JButton("View My Bookings");
        backButton = new JButton("Back to Login");

        bottomPanel.add(viewFlightsButton);
        bottomPanel.add(bookFlightButton);
        bottomPanel.add(viewMyBookingsButton);
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        viewFlightsButton.addActionListener(e -> {
            outputArea.setText("");
            if (flightManager.getFlights().isEmpty()) {
                outputArea.append("No flights available.\n");
            } else {
                for (Flight flight : flightManager.getFlights()) {
                    outputArea.append(flight.toString() + "\n");
                }
            }
        });

        bookFlightButton.addActionListener(e -> {
            String flightNumber = flightField.getText().trim();
            if (flightNumber.isEmpty()) {
                outputArea.append("Please enter a flight number to book.\n");
                return;
            }
            Flight selectedFlight = flightManager.findFlightByNumber(flightNumber);
            if (selectedFlight != null && selectedFlight.getAvailableSeats() > 0) {
                guestPassenger.bookFlight(selectedFlight);
                outputArea.append("Successfully booked Flight: " + flightNumber + "\n");
            } else {
                outputArea.append("Flight not found or no seats available.\n");
            }
        });

        viewMyBookingsButton.addActionListener(e -> {
            outputArea.setText("");
            if (guestPassenger.getBookings().isEmpty()) {
                outputArea.append("You have no bookings.\n");
            } else {
                for (Booking booking : guestPassenger.getBookings()) {
                    outputArea.append(booking.toString() + "\n");
                }
            }
        });

        backButton.addActionListener(e -> {
            new LoginGUI(flightManager).setVisible(true); // ✅ Important: pass again
            dispose();
        });

        setVisible(true);
    }
}
