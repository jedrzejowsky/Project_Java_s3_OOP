package Skills;

public class Skill {
    private String name;
    private float damage;

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

}