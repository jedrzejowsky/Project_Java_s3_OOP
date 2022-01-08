package Heroes;

import SkillsAndUpgrades.Skill;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.baseHealth = 100;
        this.currentHealth = baseHealth;
        this.alive = true;
        skills();
    }

    @Override
    void skills() {
        addSkill(new Skill("Strong Attack", 10))
                .addSkill(new Skill("Quick Attack", 7));
    }

}
