package com.ana.solid.s;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public final class RegistrationService {

    private final UserValidator validator;
    private final EmailService emailService;
    private final BooleanSupplier confirmationPolicy;

    public RegistrationService(UserValidator validator,
                               EmailService emailService,
                               BooleanSupplier confirmationPolicy) {
        this.validator = Objects.requireNonNull(validator);
        this.emailService = Objects.requireNonNull(emailService);
        this.confirmationPolicy = Objects.requireNonNull(confirmationPolicy);
    }

    public RegistrationResult register(User user) {
        validator.validate(user);

        emailService.sendConfirmationEmail(user.getEmail());

        boolean confirmed = confirmationPolicy.getAsBoolean();
        return confirmed ? RegistrationResult.REGISTERED : RegistrationResult.NOT_CONFIRMED;
    }
}
