package SkillsAndUpgrades;

public class Skill {
    protected String name;
    protected float damage;

    public Skill(String name, float damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getSkillName() {
        return name;
    }

    public float getSkillDamage() {
        return damage;
    }

    public void upgradeDamage(float upgrade) {
        damage += upgrade;
    }

}
