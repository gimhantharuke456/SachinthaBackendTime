package com.backend.sachinthabackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources")
public class Resource {

    @Id
    private String id;
    private String type; // e.g., Classroom, Projector, Lab
    private String location;
    private boolean isAvailable;

    // Default constructor
    public Resource() {
    }

    // Parameterized constructor
    public Resource(String type, String location, boolean isAvailable) {
        this.type = type;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Override toString() method for better logging and debugging
    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
