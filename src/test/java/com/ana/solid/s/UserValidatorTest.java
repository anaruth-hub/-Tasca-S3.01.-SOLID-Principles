package com.ana.solid.s;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    void shouldThrowWhenEmailIsInvalid() {
        User user = new User("Ana", "invalidEmail", "Password1");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertEquals("Invalid email address.", ex.getMessage());
    }

    @Test
    void shouldThrowWhenPasswordIsInvalid() {
        User user = new User("Ana", "ana@test.com", "password"); // no uppercase
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validator.validate(user));
        assertTrue(ex.getMessage().contains("Password must be"));
    }

    @Test
    void shouldPassWhenUserIsValid() {
        User user = new User("Ana", "ana@test.com", "Password1");
        assertDoesNotThrow(() -> validator.validate(user));
    }
}
