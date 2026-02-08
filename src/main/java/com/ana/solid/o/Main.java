package com.ana.solid.o;

import java.util.Map;

public final class Main {
    public static void main(String[] args) {
        InstrumentPlayer player = new InstrumentPlayer(Map.of(
                "guitar", new Guitar(),
                "drums", new Drums(),
                "piano", new Piano()
        ));

        player.play("guitar");
        player.play("drums");
        player.play("piano");
    }
}
