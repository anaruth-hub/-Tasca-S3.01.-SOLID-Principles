package com.ana.solid.o;

public final class Drums implements Instrument {

    @Override
    public String name() {
        return "drums";
    }

    @Override
    public void play() {
        System.out.println("🥁 Beating the drums");
    }
}
