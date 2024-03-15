package com.backend.sachinthabackend;

import com.backend.sachinthabackend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserJunitTest {

    @Test
    void shouldCreateNewUser(){
        var test =new User(

        );
        test.setPassword("123456");
        test.setEmail("test@test.com");

        Assertions.assertEquals("test@test.com",test.getEmail());
    }
}
