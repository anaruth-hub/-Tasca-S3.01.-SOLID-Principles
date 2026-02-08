package com.ana.solid.o;

public final class UnknownInstrumentException extends RuntimeException  {
    public UnknownInstrumentException(String instrumentName) {
        super("Unknown instrument: " + instrumentName);
    }
}
