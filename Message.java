package oop_project;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Message {
    protected User sender;
    protected User reciever;
    protected String message;
    protected LocalDateTime timestamp;

    public Message(User sender, User reciever, String message, LocalDate date, LocalTime time) {
        this.sender = sender;
        this.reciever = reciever;
        this.message = message;
        this.date = date;
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
