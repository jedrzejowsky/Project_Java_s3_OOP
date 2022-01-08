package Enemies.Bosses;

import Enemies.Enemy;
import Heroes.Hero;
import Interfaces.Boss;
import Log.Log;
import SkillsAndUpgrades.Skill;

import java.util.ArrayList;
import java.util.Random;

public class Hag extends Enemy implements Boss {
    private ArrayList<Skill> skills = new ArrayList<>();

    Random random = new Random();
    Log log = new Log();

    public Hag() {
        this.health = 220;
        skills();
    }

    @Override
    public void skills() {
        skills.add(new Skill("Pot attack", 12));
        skills.add(new Skill("Tenderize", 25));
        skills.add(new Skill("Spill boiling water", 16.5f));
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
        return 130;
    }

}
