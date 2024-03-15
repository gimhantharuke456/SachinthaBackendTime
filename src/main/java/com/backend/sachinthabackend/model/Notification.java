package com.backend.sachinthabackend.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Document(collection = "notifications")
public class Notification {

    // Getters and Setters
    @Id
    private String id;
    private String recipientId; // User ID
    private String type; // e.g., Timetable Change, Room Change, Announcement
    private String message;
    private LocalDateTime dateTime;

    // Default constructor
    public Notification() {
    }

    // Parameterized constructor
    public Notification(String recipientId, String type, String message, LocalDateTime dateTime) {
        this.recipientId = recipientId;
        this.type = type;
        this.message = message;
        this.dateTime = dateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Override toString() method for better logging and debugging
    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
