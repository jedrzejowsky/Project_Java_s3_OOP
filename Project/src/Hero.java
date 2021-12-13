public class Hero extends Model {

    Hero(String name, int damage, int health) {
        super(name, damage, health);
    }

    @Override
    public void attack(Model opponent) {
        opponent.health -= damage;
        System.out.println(name + " hit for: " + damage);
        System.out.println(opponent.name + " now have " + opponent.health + " HP");

        if(opponent.health<=0) {
            dead = true;
        }
    }
}
