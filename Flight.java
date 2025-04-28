import java.util.List;

public class Flight {
    private String FlightNumber;
    private String DepartureCity;
    private String ArrivalCity;
    private String source;
    private String destination;
    private String DepartureTime;
    private String ArrivalTime;
    private int totalSeats;
    private int availableSeats;
    private Pilot assignedPilot;
    private String FlightId;

    public Flight(String flightNumber, String departureCity, String arrivalCity, String departureTime, String arrivalTime, int totalSeats, int availableSeats, Pilot assignedPilot) {
        FlightNumber = flightNumber;
        DepartureCity = departureCity;
        ArrivalCity = arrivalCity;
        DepartureTime = departureTime;
        ArrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getFlightId() {
        return FlightId;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }
    public String getDepartureCity() {
        return DepartureCity;
    }
    public String getArrivalCity() {
        return ArrivalCity;
    }
    public String getDepartureTime() {
        return DepartureTime;
    }
    public String getArrivalTime() {
        return ArrivalTime;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public Pilot getAssignedPilot(Pilot pilot){
        return assignedPilot;
    }
    public void assignPilot(Pilot pilot){

        this.assignedPilot = pilot;
    }

    public void bookSeat(){
        if(availableSeats > 0){
            availableSeats--;
            System.out.println("seat  is booked");
        }
        else{
            System.out.println("no seats available");
        }
    }
    public void cancelSeat(){
        if(availableSeats < totalSeats){
            availableSeats++;
        }
    }
    public void setAvailableSeats(int availableSeats){
        this.availableSeats = availableSeats;
    }

    public void AssignPilot(Pilot pilot){
        this.assignedPilot = pilot;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "FlightNumber='" + FlightNumber + '\'' +
                ", DepartureCity='" + DepartureCity + '\'' +
                ", ArrivalCity='" + ArrivalCity + '\'' +
                ", DepartureTime='" + DepartureTime + '\'' +
                ", ArrivalTime='" + ArrivalTime + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", assignedPilot=" + assignedPilot +
                '}';
    }
}
