package com.backend.sachinthabackend.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "enrollments")
public class Enrollment {

    // Getters and Setters
    @Id
    private String id;
    private String studentId;
    private String courseId;
    private String status; // For example, "enrolled", "completed"

    // Default constructor
    public Enrollment() {
    }

    // Parameterized constructor
    public Enrollment(String studentId, String courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString() method for better logging and debugging
    @Override
    public String toString() {
        return "Enrollment{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
