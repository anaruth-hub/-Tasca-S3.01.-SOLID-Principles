package com.ana.solid.d;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class ServicePersonTest {

    @Test
    void shouldDelegateSaveToRepository() {
        AtomicBoolean called = new AtomicBoolean(false);

        PersonRepository fakeRepo = person -> called.set(true);

        ServicePerson service = new ServicePerson(fakeRepo);
        service.savePerson(new Person("Ana"));

        assertTrue(called.get());
    }

    @Test
    void shouldThrowWhenRepositoryIsNull() {
        assertThrows(NullPointerException.class, () -> new ServicePerson(null));
    }
}
