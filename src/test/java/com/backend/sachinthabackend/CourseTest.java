package com.backend.sachinthabackend;
import com.backend.sachinthabackend.model.Course;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CourseTest {
    @Test
    void createCourse_Success() {
        Course course = new Course("Software Engineering", "SE101", "Introduction to Software Engineering", 4, "John Doe");

        assertAll(
                () -> assertNotNull(course.getName()),
                () -> assertNotNull(course.getCode()),
                () -> assertNotNull(course.getDescription()),
                () -> assertTrue(course.getCredits() > 0),
                () -> assertNotNull(course.getAssignedFaculty())
        );
    }

    @Test
    void createCourse_Failure_EmptyName() {
        Course course = new Course(null, "SE101", "Introduction to Software Engineering", 4, "John Doe");

        assertAll(
                () -> assertNotNull(course.getName()),
                () -> assertNotNull(course.getCode()),
                () -> assertNotNull(course.getDescription()),
                () -> assertTrue(course.getCredits() > 0),
                () -> assertNotNull(course.getAssignedFaculty())
        );
    }
}
