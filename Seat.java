package oop_project;

public class Seat {
    protected String seatNumber;
    protected String seatType; //economy, business, first Class
    protected Boolean available;

    public Seat(String seatNumber, String seatType, Boolean available) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.available = available;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
