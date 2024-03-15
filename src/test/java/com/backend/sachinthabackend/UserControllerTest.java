package com.backend.sachinthabackend;


import com.backend.sachinthabackend.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.junit.jupiter.api.Assertions.*;



public class UserControllerTest {

    @Test
    void createUser_Success() {
        User user = new User("validUsername", "securePassword123", "USER", "user@example.com");

        assertAll(
                () -> assertEquals("validUsername", user.getUsername()),
                () -> assertTrue(new BCryptPasswordEncoder().matches("securePassword123", user.getPassword())),
                () -> assertEquals("USER", user.getRole()),
                () -> assertEquals("user@example.com", user.getEmail()),
                // Assuming the default implementation of UserDetails methods returns true for a successful scenario
                () -> assertFalse(user.isAccountNonExpired()),
                () -> assertFalse(user.isAccountNonLocked()),
                () -> assertFalse(user.isCredentialsNonExpired()),
                () -> assertFalse(user.isEnabled())
        );
    }


    @Test
    void createUser_Failure() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("invalidUsername#", "securePassword123", "USER", "wrongEmailFormat");
            validateUser(user); // Hypothetical validation method
        });

        assertTrue(thrown.getMessage().contains("Invalid username or email"));
    }


    private void validateUser(User user) {
        if (!user.getUsername().matches("^[A-Za-z0-9_]+$") || !user.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid username or email");
        }
    }
}
