package com.ana.solid.s;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {

    @Test
    void shouldRegisterWhenConfirmed() {
        AtomicBoolean emailSent = new AtomicBoolean(false);

        EmailService fakeEmailService = email -> emailSent.set(true);
        BooleanSupplier alwaysConfirmed = () -> true;

        RegistrationService service = new RegistrationService(
                new UserValidator(),
                fakeEmailService,
                alwaysConfirmed
        );

        RegistrationResult result = service.register(new User("Ana", "ana@test.com", "Password1"));

        assertTrue(emailSent.get());
        assertEquals(RegistrationResult.REGISTERED, result);
    }

    @Test
    void shouldReturnNotConfirmedWhenUserDoesNotConfirm() {
        EmailService fakeEmailService = email -> { /* do nothing */ };
        BooleanSupplier neverConfirmed = () -> false;

        RegistrationService service = new RegistrationService(
                new UserValidator(),
                fakeEmailService,
                neverConfirmed
        );

        RegistrationResult result = service.register(new User("Ana", "ana@test.com", "Password1"));

        assertEquals(RegistrationResult.NOT_CONFIRMED, result);
    }
}
