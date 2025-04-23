import java.util.ArrayList;

public abstract class Passenger extends User{
    private ArrayList<Booking> bookings;
    public Passenger(String username, String password) {
        super(username, password);
        this.bookings = new ArrayList<>();
    }
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void cancelBooking(String bookingId) {
        bookings.removeIf(booking -> booking.getBookingID().equals(bookingId));
    }
    public void viewBookings() {
        if(bookings.isEmpty()) {
            System.out.println("No bookings found");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
    public void bookFlight(Flight flight){
        Booking newBooking = new Booking(flight,this);
        addBooking(newBooking);
        System.out.println("Booking successfull, booking ID: " + newBooking.getBookingID());
    }

}
