package com.backend.sachinthabackend.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Document(collection = "timetables")
public class Timetable {

    // Getters and Setters
    @Id
    private String id;
    private String courseId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private String facultyId;

    // Default constructor
    public Timetable() {
    }

    // Parameterized constructor
    public Timetable(String courseId, LocalDateTime startTime, LocalDateTime endTime, String location, String facultyId) {
        this.courseId = courseId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.facultyId = facultyId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    // Override toString() method for better logging and debugging
    @Override
    public String toString() {
        return "Timetable{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }
}
