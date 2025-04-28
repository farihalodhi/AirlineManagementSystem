import java.util.ArrayList;

public class Passenger extends User{
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
        if(flight.getAvailableSeats()>0){
            flight.bookSeat();
            Booking newBooking = new Booking(flight,this);
            addBooking(newBooking);
            System.out.println("Booking successfull, booking ID: " + newBooking.getBookingID());
        } else {
            System.out.println("Booking failed: no seats available");
        }
    }
    public void cancelBooking(String bookingId) {
        Booking toRemove = null;
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingId)) {
                booking.getFlight().cancelSeat(); // Restore seat
                toRemove = booking;
                break;
            }
        }
        if (toRemove != null) {
            bookings.remove(toRemove);
            System.out.println("Booking cancelled: " + bookingId);
        } else {
            System.out.println("No booking found with ID: " + bookingId);
        }
    }


}
