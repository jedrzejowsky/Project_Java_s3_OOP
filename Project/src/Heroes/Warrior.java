package Heroes;

import SkillsAndUpgrades.Skill;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
        this.health = 50;
        this.alive = true;
        skills();
    }

    @Override
    void skills() {
       addSkill(new Skill("Attack1", 10))
               .addSkill(new Skill("Attack2", 5));
    }

    public Skill getSkill() {
        return skills.get(1);
    }

}
