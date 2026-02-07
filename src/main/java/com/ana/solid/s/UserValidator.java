package com.ana.solid.s;

public final class UserValidator {

    public void validate(User user) {
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
    }

    private void validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    private void validatePassword(String password) {
        if (!PasswordPolicy.isValid(password)) {
            throw new IllegalArgumentException(
                    "Password must be at least 8 characters long and contain an uppercase letter."
            );
        }
    }
}
