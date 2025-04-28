import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class AdminDashboard extends JFrame {
    private JTextField flightField;
    private JTextArea outputArea;
    private JButton addFlightBtn,removeFlightBtn, assignPilotBtn, assignHostessBtn, viewUsersBtn;
    private String adminName;
    private FlightManager flightManager;
    private AssignedFlightManager assignedFlightManager;


    private List<Flight> flights = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Pilot> pilots = new ArrayList<>();
    private List<AirHostess> hostesses = new ArrayList<>();
    private Admin admin = new Admin();


    public AdminDashboard(String adminName,FlightManager flightManager) {
        this.adminName = adminName;
        this.flightManager = flightManager;
        this.assignedFlightManager = new AssignedFlightManager();
        setTitle("Admin Panel - " + adminName);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Flight Name:"));
        flightField = new JTextField(20);
        topPanel.add(flightField);
        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

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
                    Flight newFlight = new Flight(flightNum, "Karachi", "Lahore", "10:00 AM", "12:00 PM", 100, 100, null);
                    flightManager.addFlight(newFlight);
                    outputArea.append("Flight added: " + flightNum + "\n");
                    flightField.setText("");
                } else {
                    outputArea.append("Please enter a flight number.\n");
                }
            }
        });

        removeFlightBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flightNum = flightField.getText().trim();
                if (!flightNum.isEmpty()) {
                    boolean removed = flightManager.removeFlight(flightNum);
                    if (removed) {
                        outputArea.append("Flight removed: " + flightNum + "\n");
                    } else {
                        outputArea.append("Flight not found: " + flightNum + "\n");
                    }
                    flightField.setText("");
                } else {
                    outputArea.append("Please enter a flight number to remove.\n");
                }
            }
        });
        assignPilotBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(AdminDashboard.this, "Enter Pilot Username:");
                String flightNum = flightField.getText().trim();

                if (!username.isEmpty() && !flightNum.isEmpty()) {
                    assignedFlightManager.assignFlightToUser("Pilot", username, flightNum);
                    outputArea.append("Flight " + flightNum + " assigned to Pilot " + username + "\n");
                } else {
                    outputArea.append("Please provide both Pilot username and Flight number.\n");
                }
            }
        });

        assignHostessBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = JOptionPane.showInputDialog(AdminDashboard.this, "Enter AirHostess Username:");
                String flightNum = flightField.getText().trim();

                if (!username.isEmpty() && !flightNum.isEmpty()) {
                    assignedFlightManager.assignFlightToUser("AirHostess", username, flightNum);
                    outputArea.append("Flight " + flightNum + " assigned to AirHostess " + username + "\n");
                } else {
                    outputArea.append("Please provide both AirHostess username and Flight number.\n");
                }
            }
        });

        viewUsersBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                if (flightManager.getFlights().isEmpty()) {
                    outputArea.append("No flights available.\n");
                } else {
                    for (Flight flight : flightManager.getFlights()) {
                        outputArea.append(flight.toString() + "\n");
                    }
                }
            }
        });


    }
}