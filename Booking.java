package oop_project;

import java.util.List;

public class Booking {
    protected String bookingID;
    protected Flight flight;
    //protected Passenger passenger;
    protected String bookingDate;
    protected String bookingTime;
    protected List<Service> services;

    public Booking(String bookingID, Flight flight, String bookingDate, String bookingTime, List<Service> services) {
        this.bookingID = bookingID;
        this.flight = flight;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.services = services;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
