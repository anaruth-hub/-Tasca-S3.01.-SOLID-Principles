What was wrong:

(s) -> User was doing many things like: modeling, validation, email sending, and confirmation.
(d)

Why it violated SRP:

(s) -> There were several reasons to change the class.
(d)
What solution you applied:

(s) -> I separated:
    - User entity
    - UserValidator validation
    - EmailService sending confirmation
    - RegistrationService use case orchestration
Why it's better:
More testable, more maintainable, less coupling.

(d)