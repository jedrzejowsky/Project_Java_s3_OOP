package Enemies;

import Heroes.Hero;
import Interfaces.Entity;
import Log.Log;

import java.util.Random;

public abstract class Enemy implements Entity {
    protected String name;
    protected float damage;
    protected float health;

    Random random = new Random();
    Log log = new Log();

    public Enemy() {
        this.name = getClass().getSimpleName();
        this.damage = 0;
        this.health = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getHealth() {
        return health;
    }

    public void damaged(float damage) {
        health -= damage;
    }

    public void attack(Hero hero) {
        hero.damaged(damage);
        log.info(hero.getName() + " got hit for: " + damage + " DMG. Current health " + hero.getHealth() + " HP");

        if(hero.getHealth() <= 0.0) {
            log.died(hero);
            hero.died();
        }
    }

    public int dropMoney() {
        return random.nextInt(7-2)+2;
    }

    public void upgradeHealthAndDamage(float upgradeDamage, float upgradeHealth) {
        damage += upgradeDamage;
        health += upgradeHealth;
    }

}
