package com.ana.solid.o;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentPlayerTest {

    @Test
    void shouldPlayKnownInstrument() {
        AtomicBoolean played = new AtomicBoolean(false);

        Instrument testInstrument = new Instrument() {
            @Override public String name() { return "test"; }
            @Override public void play() { played.set(true); }
        };

        InstrumentPlayer player = new InstrumentPlayer(Map.of("test", testInstrument));
        player.play("test");

        assertTrue(played.get());
    }

    @Test
    void shouldThrowWhenInstrumentIsUnknown() {
        InstrumentPlayer player = new InstrumentPlayer(Map.of());

        assertThrows(UnknownInstrumentException.class, () -> player.play("violin"));
    }
}
