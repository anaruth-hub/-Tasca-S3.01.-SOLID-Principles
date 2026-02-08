package com.ana.solid.l;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiskovSubstitutionTest {

    @Test
    void allCharactersCanAttack() {
        Character ghost = new Ghost();
        Character warrior = new Warrior();

        assertDoesNotThrow(ghost::attack);
        assertDoesNotThrow(warrior::attack);
    }

    @Test
    void onlyDamageableCharactersCanTakeDamage() {
        Character ghost = new Ghost();
        Character warrior = new Warrior();

        assertFalse(ghost instanceof Damageable);
        assertTrue(warrior instanceof Damageable);

        Damageable damageableWarrior = (Damageable) warrior;
        assertDoesNotThrow(() -> damageableWarrior.takeDamage(10));
    }
}
