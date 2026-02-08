package com.ana.solid.s;

public final class ConsoleEmailService implements EmailService {
    @Override
    public void sendConfirmationEmail(String email) {
        System.out.println("Sending confirmation email to: " + email);
    }
}
