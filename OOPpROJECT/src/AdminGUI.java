package oop_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class AdminGUI extends JFrame {
    private JTextField flightField;
    private JTextArea outputArea;
    private JButton addFlightBtn, removeFlightBtn, assignPilotBtn, assignHostessBtn, viewUsersBtn;

   // private List<Flight> flights = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Pilot> pilots = new ArrayList<>();
    private List<AirHostess> hostesses = new ArrayList<>();
    private Admin admin = new Admin();

    public AdminGUI() {
        setTitle("Admin Panel");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel: Flight Input
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Flight Name:"));
        flightField = new JTextField(20);
        topPanel.add(flightField);
        add(topPanel, BorderLayout.NORTH);


        // Center Panel: Output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Bottom Panel: Buttons
        JPanel bottomPanel = new JPanel(new GridLayout(2, 3));

        addFlightBtn = new JButton("Add Flight");
        removeFlightBtn = new JButton("Remove Flight");
        assignPilotBtn = new JButton("Assign Pilot");
        assignHostessBtn = new JButton("Assign Hostess");
        viewUsersBtn = new JButton("View Users");

        bottomPanel.add(addFlightBtn);
        bottomPanel.add(removeFlightBtn);
        bottomPanel.add(assignPilotBtn);
        bottomPanel.add(assignHostessBtn);
        bottomPanel.add(viewUsersBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        addFlightBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flightNum = flightField.getText().trim();
                if (!flightNum.isEmpty()) {
                    // Replace dummy data with more fields later
                    Flight newFlight = new Flight(flightNum, "Karachi", "Lahore", "10:00", "12:00", 100, 100, null);
                    admin.addFlight(newFlight);
                    outputArea.append("Flight added: " + flightNum + "\n");
                    flightField.setText("");
                } else {
                    outputArea.append("Please enter a flight number.\n");
                }
            }
        });
        viewUsersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(""); // Clear previous text
                for (Flight flight : admin.getAllFlights()) {
                    outputArea.append(flight.toString() + "\n");
                }
            }
        });


    }

//
    public static void main(String[] args) {

        AdminGUI gui= new AdminGUI();
        gui.setVisible(true);
    }
}
