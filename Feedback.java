package oop_project;

public class Feedback {
    protected Passenger passenger;
    protected Flight flight;
    protected String comment;
    protected int rating; //(1-5)

    public Feedback(Passenger passenger, Flight flight, String comment, int rating) {
        this.passenger = passenger;
        this.flight = flight;
        this.comment = comment;
        this.rating = rating;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
