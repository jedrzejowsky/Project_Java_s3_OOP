abstract class Model {
    String name;
    int damage;
    int health;
    public boolean dead;

    Model(String name, int damage, int health) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    abstract void attack(Model opponent);
}
