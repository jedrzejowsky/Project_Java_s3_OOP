package Heroes;

import Arena.Combat;
import Enemies.Enemy;
import Interfaces.Boss;
import Interfaces.Entity;
import Log.Log;
import SkillsAndUpgrades.*;

import java.util.ArrayList;

public abstract class Hero implements Entity {
    protected String name;
    protected float baseHealth;
    protected float currentHealth;
    protected boolean alive;
    protected int gatheredMoney = 0;

    private int defeatedHordes = 0;
    private int defeatedEnemies = 0;
    private int defeatedBosses = 0;
    private int allGatheredMoney = 0;

    protected ArrayList<Skill> skills = new ArrayList<>();

    Log log = new Log();
    Inventory inventory = new Inventory();

    Hero(String name) {
        this.name = name;
        this.baseHealth = 0;
        this.alive = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getHealth() {
        return currentHealth;
    }

    public boolean isAlive() {
        return alive;
    }

    public void died() {
        alive = false;
    }

    public float getBaseHealth() {
        return baseHealth;
    }

    public void damaged(float damage) {
        currentHealth -= damage;
    }

    public void attack(ArrayList<Enemy> enemies, Enemy enemy) {
        Combat combat = new Combat();

        log.info("Target: " + enemy.getName() + ", HP: " + enemy.getHealth());
        enemy.damaged(combat.chooseSkill(skills));
        combat.combatLog(enemy, skills.get(combat.getChosenSkill()));

        if(enemy.getHealth() <= 0.0) {
            if(enemy instanceof Boss) {
                defeatedBosses += 1;
            }
            else {
                defeatedEnemies += 1;
            }

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

    public int getGatheredMoney() {
        return gatheredMoney;
    }

    public void buy(int price) {
        gatheredMoney -= price;
    }

    public void collectMoney(int money) {
        gatheredMoney += money;
        allGatheredMoney += money;
    }

    public void upgradeHealth(float upgrade, int price) {
        gatheredMoney -= price;
        baseHealth += upgrade;
    }

    public void heal(float healingValue) {
        currentHealth += baseHealth * (healingValue/100);

        if(currentHealth>baseHealth) {
            currentHealth = baseHealth;
        }
    }

    public ArrayList<Skill> getAllSkills() {
        return skills;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void hordeDefeated() {
        defeatedHordes += 1;
    }

    public void statistics() {
        log.info("");
        log.info("During this run you've...");
        log.info("Defeated " + defeatedHordes + " hordes.");
        log.info("That means " + defeatedEnemies + " enemies and " + defeatedBosses + " bosses.");
        log.info("Throughout this run you've collected " + allGatheredMoney + "$");
    }

    abstract void skills();
}
