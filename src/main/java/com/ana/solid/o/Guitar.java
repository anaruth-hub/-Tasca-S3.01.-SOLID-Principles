package com.ana.solid.o;

public final class Guitar implements Instrument {
    @Override
    public String name() {
        return "guitar";
    }

    @Override
    public void play() {
        System.out.println("🎸 Strumming the guitar");
    }
}
