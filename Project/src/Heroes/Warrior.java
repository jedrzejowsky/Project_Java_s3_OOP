package Heroes;

import SkillsAndUpgrades.Skill;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.baseHealth = 50;
        this.currentHealth = baseHealth;
        this.alive = true;
        skills();
    }

    @Override
    void skills() {
       addSkill(new Skill("Attack1", 10))
               .addSkill(new Skill("Attack2", 5));
    }

}
