package com.ana.solid.o;

public final class Piano implements Instrument {

    @Override
    public String name() {
        return "piano";
    }

    @Override
    public void play() {
        System.out.println("🎹 Playing the piano");
    }
}
