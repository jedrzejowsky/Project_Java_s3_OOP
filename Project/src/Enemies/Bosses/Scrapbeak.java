package Enemies.Bosses;

import Enemies.Enemy;
import Heroes.Hero;
import Interfaces.Boss;
import Log.Log;
import SkillsAndUpgrades.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Scrapbeak extends Enemy implements Boss {
    private ArrayList<Skill> skills = new ArrayList<>();

    Random random = new Random();
    Log log = new Log();

    public Scrapbeak() {
        this.health = 275;
        skills();
    }

    @Override
    public void skills() {
        skills.add(new Skill("Shovel Slash", 16.5f));
        skills.add(new Skill("Concertina Throw", 12.5f));
        skills.add(new Skill("Hammer Hit", 26));
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
        return 175;
    }

}
