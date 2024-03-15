package com.backend.sachinthabackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {

    @Id
    private String id;
    private String name;
    private String code;
    private String description;
    private Integer credits;
    private String assignedFaculty;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor for easy instantiation
    public Course(String name, String code, String description, Integer credits, String assignedFaculty) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.credits = credits;
        this.assignedFaculty = assignedFaculty;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getAssignedFaculty() {
        return assignedFaculty;
    }

    public void setAssignedFaculty(String assignedFaculty) {
        this.assignedFaculty = assignedFaculty;
    }

    // Override toString() method for better logging and debugging
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", assignedFaculty='" + assignedFaculty + '\'' +
                '}';
    }
}
