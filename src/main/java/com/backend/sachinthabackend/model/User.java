package com.backend.sachinthabackend.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Getter
@Document(collection = "users")
public class User   implements UserDetails {

    // ID
    @Id
    private String id;

    // Username
    private String username;
    // Password
    private String password; // This should be hashed for security



    // Role
    private String role; // e.g., ADMIN, FACULTY, STUDENT
    // Email
    private String email;


    // Constructors, Getters, and Setters

    public User() {
    }

    public User(String username, String rawPassword, String role, String email) {
        this.username = username;
        this.setPassword(rawPassword);
        this.role = role;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        // Use BCryptPasswordEncoder to hash the password for storing securely
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
