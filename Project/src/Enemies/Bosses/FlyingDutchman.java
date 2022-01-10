package Enemies.Bosses;

import Enemies.Enemy;
import Heroes.Hero;
import Interfaces.Boss;
import Log.Log;
import SkillsAndUpgrades.Skill;

import java.util.ArrayList;
import java.util.Random;

public class FlyingDutchman extends Enemy implements Boss {
    private ArrayList<Skill> skills = new ArrayList<>();

    Random random = new Random();
    Log log = new Log();

    public FlyingDutchman() {
        this.health = 300;
        skills();
    }

    @Override
    public void skills() {
        skills.add(new Skill("Cannonball Shot", 22));
        skills.add(new Skill("Exploding Barrel", 18));
        skills.add(new Skill("Volley", 30.5f));
    }

    @Override
    public void attack(Hero hero) {
        int chooseSkill = random.nextInt(skills.size());
        hero.damaged(skills.get(chooseSkill).getSkillDamage());

        log.info(name + " uses " + skills.get(chooseSkill).getSkillName());
        log.info(hero.getName() + " got hit for: " + skills.get(chooseSkill).getSkillDamage() + ", curr heal: " + hero.getHealth());

        if(hero.getHealth() <= 0.0) {
            log.died(hero);
            hero.died();
        }
    }

    @Override
    public int dropMoney() {
        return 225;
    }

}
