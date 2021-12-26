package Enemies;

import Heroes.Hero;
import Interfaces.Entity;

public abstract class Enemy implements Entity {
    protected String name;
    public float damage;
    public float health;
    private boolean alive;

    Enemy() {
        this.name = getClass().getSimpleName();
        this.damage = 0;
        this.health = 0;
        this.alive = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void died() {
        alive = false;
    }

    public float currentHealth() {
        return health;
    }

    public void damaged(float damage) {
        health -= damage;
    }

    public void attack(Hero hero) {
        if(isAlive()) {
            hero.damaged(damage);
            System.out.println("Hero got hit for: " + damage + ", curr heal: " + hero.currentHealth());

            if(hero.currentHealth() <= 0.0) {
                System.out.println("hero died");
                hero.died();
            }
        }
    }
}
