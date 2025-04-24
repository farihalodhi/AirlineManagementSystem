public class Booking {
    private static int counter = 100;
    private String bookingID;
    private Flight flight;
    private Passenger passenger;

    public Booking(Flight flight,Passenger passenger){
        this.bookingID = "B " + counter++;
        this.flight = flight;
        this.passenger = passenger;
    }
    public String getBookingID() {
        return bookingID;
    }

    public Flight getFlight() {
        return flight;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
}
