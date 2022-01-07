package SkillsAndUpgrades;

public class Potion {
    protected String name;
    protected int healingValue;

    public Potion(String name, int healingValue) {
        this.name = name;
        this.healingValue = healingValue;
    }

    public String getName() {
        return name;
    }

    public int getHealingValue() {
        return healingValue;
    }

}
