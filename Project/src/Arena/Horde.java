package Arena;

import Enemies.*;

import java.util.ArrayList;
import java.util.Random;

public class Horde {
    private int howManyEnemies = 5;

    public void create(ArrayList<Enemy> enemies, int howMany) {
        Random random = new Random();
        int chooseEnemy;

        for(int i=0; i<howMany; i++) {
            chooseEnemy = random.nextInt(5);

            switch (chooseEnemy) {
                case 0 -> {enemies.add(new Skeleton()); System.out.println("Skeleton added");}
                case 1 -> {enemies.add(new Zombie()); System.out.println("Zombie added");}
                case 2 -> {enemies.add(new Goblin()); System.out.println("Goblin added");}
                case 3 -> {enemies.add(new Ghul()); System.out.println("Ghul added");}
                case 4 -> {enemies.add(new Orc()); System.out.println("Ork added");}
            }
        }
    }

    public int getHowManyEnemies() {
        return howManyEnemies;
    }

    //dodaje dwoch wrogow co pokonana horde
    public void setHowManyEnemies() {
        howManyEnemies += 2;
    }

}
