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
            chooseEnemy = random.nextInt(2);

            switch (chooseEnemy) {
                case 0 -> {enemies.add(new Skeleton()); System.out.println("Skeleton added");}
                case 1 -> {enemies.add(new Zombie()); System.out.println("Zombie added");}
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
