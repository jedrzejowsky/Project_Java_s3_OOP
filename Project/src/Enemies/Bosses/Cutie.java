package Enemies.Bosses;

import Enemies.Enemy;
import Heroes.Hero;
import Interfaces.Boss;
import Log.Log;
import SkillsAndUpgrades.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Cutie extends Enemy implements Boss {
    private ArrayList<Skill> skills = new ArrayList<>();

    Random random = new Random();
    Log log = new Log();

    public Cutie() {
        this.health = 100;
        skills();
    }

    @Override
    public void skills() {
        skills.add(new Skill("Trunk attack", 15));
        skills.add(new Skill("Toss", 10));
        skills.add(new Skill("Trample", 17.5f));
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
        return 75;
    }

}
