package com.ana.solid.d;

import java.util.Objects;

public final class Person {
    private final String name;

    public Person(String name) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
    }

    public String getName() {
        return name;
    }
}
