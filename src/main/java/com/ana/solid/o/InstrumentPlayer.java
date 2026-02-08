package com.ana.solid.o;

import java.util.Map;
import java.util.Objects;

public final class InstrumentPlayer {

    private final Map<String, Instrument> instrumentsByName;

    public InstrumentPlayer(Map<String, Instrument> instrumentsByName) {
        this.instrumentsByName = Map.copyOf(Objects.requireNonNull(instrumentsByName, "instrumentsByName cannot be null"));
    }

    public void play(String instrumentName) {
        Objects.requireNonNull(instrumentName, "instrumentName cannot be null");
        Instrument instrument = instrumentsByName.get(instrumentName.toLowerCase());
        if (instrument == null) {
            throw new UnknownInstrumentException(instrumentName);
        }
        instrument.play();
    }
}
