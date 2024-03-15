package com.backend.sachinthabackend;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import  com.backend.sachinthabackend.model.Timetable;
public class TimetableTest {
    @Test
    void createTimetable_Success() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusHours(2);
        Timetable timetable = new Timetable("course123", startTime, endTime, "Room 101", "faculty123");

        assertAll(
                () -> assertEquals("course123", timetable.getCourseId()),
                () -> assertEquals(startTime, timetable.getStartTime()),
                () -> assertEquals(endTime, timetable.getEndTime()),
                () -> assertEquals("Room 101", timetable.getLocation()),
                () -> assertEquals("faculty123", timetable.getFacultyId())
        );
    }
    @Test
    void createTimetable_Failure_InvalidTimeRange() {
        LocalDateTime startTime = LocalDateTime.now().plusHours(2);
        LocalDateTime endTime = LocalDateTime.now();

        // Assuming there is a check to ensure that endTime is after startTime
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Timetable("course123", startTime, endTime, "Room 101", "faculty123");
        });

        assertEquals("endTime must be after startTime", exception.getMessage());
    }
}
