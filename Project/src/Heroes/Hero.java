package Heroes;

import Enemies.Enemy;
import Interfaces.Entity;
import Log.ConsoleColors;
import Skills.*;

import java.util.ArrayList;

public abstract class Hero implements Entity {
    protected String name;
    protected float health;
    protected boolean alive;

    public ArrayList<Skill> skills = new ArrayList<>();

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

    public void attack(Enemy enemy) {
        Attack attack = new Attack();

        if(isAlive()) {
            enemy.damaged(attack.chooseSkill(skills));
            attack.combatLog(enemy, skills.get(attack.getChosenAttack()-1));

            if(enemy.currentHealth() <= 0.0) {
                System.out.print(ConsoleColors.RED);
                System.out.println(enemy.getName() + " died.");
                System.out.print(ConsoleColors.RESET);
                enemy.died();
            }
        }
    }

    public Hero addSkill(Skill skill) {
        skills.add(skill);
        return this;
    }

    abstract void skills();

}
