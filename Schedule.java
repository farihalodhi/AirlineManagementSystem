package oop_project;
import java.time.LocalDate;
import java.time.LocalTime;
public class Schedule {
    protected Flight flight;
    protected LocalTime dutyTime;
    protected LocalDate dutyDate;

    public Schedule(Flight flight, LocalTime dutyTime, LocalDate dutyDate) {
        this.flight = flight;
        this.dutyTime = dutyTime;
        this.dutyDate = dutyDate;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalTime getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(LocalTime dutyTime) {
        this.dutyTime = dutyTime;
    }

    public LocalDate getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(LocalDate dutyDate) {
        this.dutyDate = dutyDate;
    }
}
