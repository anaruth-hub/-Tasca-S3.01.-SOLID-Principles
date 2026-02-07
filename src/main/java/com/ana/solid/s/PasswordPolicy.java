package com.ana.solid.s;

public final class PasswordPolicy {

    private PasswordPolicy() {}

    public static boolean isValid(String password) {
        if (password == null) return false;
        return password.length() >= 8 && password.matches(".*[A-Z].*");
    }
}
