package com.ana.solid.d;

import java.util.Objects;

public final class ServicePerson {

    private final PersonRepository repository;

    public ServicePerson(PersonRepository repository) {
        this.repository = Objects.requireNonNull(repository, "repository cannot be null");
    }

    public void savePerson(Person person) {
        repository.save(person);
    }
}
