package Heroes;
import SkillsAndUpgrades.Skill;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
        this.baseHealth = 60;
        this.currentHealth = baseHealth;
        this.alive = true;
        skills();
    }

    @Override
    void skills() {
        addSkill(new Skill("Fire ball", 20))
                .addSkill(new Skill("Water whip", 10));
    }
}
