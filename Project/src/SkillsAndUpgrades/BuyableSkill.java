package SkillsAndUpgrades;

public class BuyableSkill extends Skill {
    private int price;

    public BuyableSkill(String name, float damage, int price) {
        super(name, damage);
        this.price = price;
    }

    public int getSkillPrice() {
        return price;
    }

}
