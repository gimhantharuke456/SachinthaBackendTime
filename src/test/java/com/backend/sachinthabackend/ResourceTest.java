package com.backend.sachinthabackend;
import com.backend.sachinthabackend.model.Resource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ResourceTest {

    @Test
    void createResource_Success() {
        Resource resource = new Resource("Classroom", "Building A, Room 101", true);

        assertAll(
                () -> assertNotNull(resource.getType()),
                () -> assertEquals("Classroom", resource.getType()),
                () -> assertNotNull(resource.getLocation()),
                () -> assertEquals("Building A, Room 101", resource.getLocation()),
                () -> assertTrue(resource.isAvailable())
        );
    }

    @Test
    void createResource_Failure_InvalidType() {
        // Assuming there is a validation that "type" cannot be null or empty
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Resource("", "Building A, Room 101", true);
        });

        assertEquals("Type cannot be empty", exception.getMessage());
    }

    @Test
    void createResource_Failure_InvalidLocation() {
        // Assuming there is a validation that "location" cannot be null or empty
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Resource("Classroom", "", true);
        });

        assertEquals("Location cannot be empty", exception.getMessage());
    }
}
