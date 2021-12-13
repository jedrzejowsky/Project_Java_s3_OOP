public class Main {
    public static void main(String[] args) {
        Enemy enemy = new Enemy("Zombie", 2, 10);
        Hero hero = new Hero("Bonzo", 5, 30);

        do {
            hero.attack(enemy);
            enemy.attack(hero);
        }
        while(!hero.isDead() || enemy.isDead());
    }
}
