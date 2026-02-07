What was wrong:

(s) -> User was doing many things like: modeling, validation, email sending, and confirmation.
(d) -> ServicePerson created MySql directly (new MySql()), it was coupled.

Why it violated SRP:

(s) -> There were several reasons to change the class.
(d) -> The high-level module depended on a specific implementation.

What solution you applied:
(s) -> I separated:
    - User entity
    - UserValidator validation
    - EmailService sending confirmation
    - RegistrationService use case orchestration
(d) -> I created PersonRepository (an abstraction) and moved MySQL to MySqlPersonRepository.

Why it's better:
(s) -> More testable, more maintainable, less coupling.
(d) -> I can change MySQL to another implementation (Memory, MongoDB, API) without modifying ServicePerson.
It's also easier to test.