package com.ana.solid.i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineInterfacesTest {

    @Test
    void airConditionerShouldNotBeWashable() {
        AirConditioner ac = new AirConditioner();
        assertFalse(Washable.class.isInstance(ac));
    }

    @Test
    void washingMachineShouldNotBeHeaterOrCooler() {
        WashingMachine wm = new WashingMachine();
        assertFalse(Heater.class.isInstance(wm));
        assertFalse(Cooler.class.isInstance(wm));
    }

    @Test
    void washingMachineShouldBeWashableAndSwitchable() {
        WashingMachine wm = new WashingMachine();
        assertTrue(Washable.class.isInstance(wm));
        assertTrue(Switchable.class.isInstance(wm));
        // opcional:
        assertInstanceOf(Washable.class, wm);
        assertInstanceOf(Switchable.class, wm);
    }
}
