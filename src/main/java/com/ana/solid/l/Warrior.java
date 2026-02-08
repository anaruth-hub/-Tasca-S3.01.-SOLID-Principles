package com.ana.solid.l;

public final class Warrior extends Character implements Damageable {

    @Override
    public void attack() {
        System.out.println("The warrior strikes with a sword.");
    }

    @Override
    public void takeDamage(int points) {
        int effective = points / 2;
        System.out.println("The warrior resists and only takes " + effective + " points of damage.");
    }
}
