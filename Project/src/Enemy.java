public class Enemy extends Model {

    Enemy(String name, int damage, int health) {
        super(name, damage, health);
        this.dead = false;
    }
}
