package com.ana.solid.d;

import java.util.Objects;

public final class MySqlPersonRepository implements PersonRepository {

    @Override
    public void save(Person person) {
        Objects.requireNonNull(person, "person cannot be null");
        System.out.println("Save person ok...");
    }
}
