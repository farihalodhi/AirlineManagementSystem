import java.util.ArrayList;
import java.util.List;

public class Pilot extends User{
    private String LicenseNum;
    private List<Flight> assignedFlights;

    public Pilot(String username, String password, String licenseNum, List<Flight> assignedFlights) {
        super(username, password);
        this.LicenseNum = licenseNum;
        this.assignedFlights = new ArrayList<>();
    }
    public String getLicenseNum() {
        return LicenseNum;
    }
    public void setLicenseNum(String licenseNum) {
        LicenseNum = licenseNum;
    }
    public List<Flight> getAssignedFlights() {
        return assignedFlights;
    }
    public void assignFlights(Flight flight) {
        assignedFlights.add(flight);
        flight.assignPilot(this);
    }
    public void viewSchedule(){
        System.out.println("Schedule for Pilot " + getName());
        for(Flight flight : assignedFlights){
            System.out.println(flight);
        }
    }
    public void displayDashboard(){
        System.out.println("Pilot Dashboard");
        viewSchedule();
    }
}
