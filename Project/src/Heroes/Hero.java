package Heroes;

import Arena.Combat;
import Enemies.Enemy;
import Interfaces.Entity;
import Log.Log;
import SkillsAndUpgrades.*;

import java.util.ArrayList;

public abstract class Hero implements Entity {
    protected String name;
    protected float health;
    protected boolean alive;
    protected int gatheredMoney = 0;

    protected ArrayList<Skill> skills = new ArrayList<>();
    Log log = new Log();

    Hero(String name) {
        this.name = name;
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

    public void attack(ArrayList<Enemy> enemies, Enemy enemy) {
        Combat combat = new Combat();

        log.info("Target: " + enemy.getName() + ", HP: " + enemy.getHealth());
        enemy.damaged(combat.chooseSkill(skills));
        combat.combatLog(enemy, skills.get(combat.getChosenSkill()));

        if(enemy.currentHealth() <= 0.0) {
            log.died(enemy);
            collectMoney(enemy.dropMoney());
            enemies.remove(enemy);
            System.out.println();
        }
    }

    public Hero addSkill(Skill skill) {
        skills.add(skill);
        return this;
    }

    public void buySkill(BuyableSkill skill, int price) {
        gatheredMoney -= price;
        skills.add(skill);
    }

    abstract void skills();

    public int getGatheredMoney() {
        return gatheredMoney;
    }

    public void buy(int price) {
        gatheredMoney -= price;
    }

    public void collectMoney(int money) {
        gatheredMoney += money;
    }

    public void upgradeHealth(float upgrade, int price) {
        gatheredMoney -= price;
        health += upgrade;
    }

    public ArrayList<Skill> getAllSkills() {
        return skills;
    }

}
