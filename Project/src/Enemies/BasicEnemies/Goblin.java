package Enemies.BasicEnemies;

import Enemies.Enemy;
import Log.Log;

import java.util.Random;

public class Goblin extends Enemy {
    Random random = new Random();
    Log log = new Log();

    public Goblin() {
        this.damage = 3;
        this.health = 5;
    }

    @Override
    public int dropMoney() {
        int checkLuck = random.nextInt(100);

        if(checkLuck == 99) {
            log.goblinDroppedHundred();
            return 100;
        }
        else {
            return random.nextInt(7-2)+2;
        }
    }

}
