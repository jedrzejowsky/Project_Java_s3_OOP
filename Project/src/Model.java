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

    public void attack(Model attacker, Model opponent) {
        opponent.health -= attacker.damage;
        System.out.println(attacker.name + " hit for: " + attacker.damage);
        System.out.println(opponent.name + " now have " + opponent.health + " HP");

        if(opponent.health<=0) {
            dead = true;
        }
    }
}
