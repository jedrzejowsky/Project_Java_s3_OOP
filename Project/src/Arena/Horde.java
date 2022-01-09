package Arena;

import Enemies.*;
import Enemies.BasicEnemies.*;
import Enemies.Bosses.*;

import java.util.ArrayList;
import java.util.Random;

public class Horde {
    private int howManyEnemies = 5;
    private float upgradeHealth = 0;
    private float upgradeDamage = 0;

    public void create(ArrayList<Enemy> enemies, int waveNumber) {
        Random random = new Random();
        int chooseEnemy;

        if(waveNumber % 5 != 0) {
            for(int i=0; i<howManyEnemies; i++) {
                chooseEnemy = random.nextInt(5);

                switch(chooseEnemy) {
                    case 0 -> {enemies.add(new Skeleton()); System.out.println("Skeleton added");}
                    case 1 -> {enemies.add(new Zombie()); System.out.println("Zombie added");}
                    case 2 -> {enemies.add(new Goblin()); System.out.println("Goblin added");}
                    case 3 -> {enemies.add(new Ghul()); System.out.println("Ghul added");}
                    case 4 -> {enemies.add(new Orc()); System.out.println("Ork added");}
                }
            }
        }
        //co pięć fali boss, od dziesiątej dopiero trudniejsze dodane
        else {
            if(waveNumber>=10) {
                chooseEnemy = random.nextInt(5);
                switch(chooseEnemy) {
                    case 0 -> {enemies.add(new Kayran()); System.out.println("Kayran added");}
                    case 1 -> {enemies.add(new FlyingDutchman()); System.out.println("Flying Dutchman added");}
                    case 2 -> {enemies.add(new Cutie()); System.out.println("Cutie added");}
                    case 3 -> {enemies.add(new Hag()); System.out.println("Hag added");}
                    case 4 -> {enemies.add(new Scrapbeak()); System.out.println("Scrapbeak added");}
                }
            }
            else {
                chooseEnemy = random.nextInt(2);
                switch(chooseEnemy) {
                    case 0 -> {enemies.add(new Kayran()); System.out.println("Kayran added");}
                    case 1 -> {enemies.add(new Cutie()); System.out.println("Cutie added");}
                }
            }
        }
    }

    public int getHowManyEnemies() {
        return howManyEnemies;
    }

    //dodaje dwoch wrogow co dwie rundy
    public void setHowManyEnemies(int waveNumber) {
        if(waveNumber % 2 == 0) {
            howManyEnemies += 2;
        }
    }

    public void upgrade(ArrayList<Enemy> enemies) {
            for(Enemy enemy: enemies) {
                enemy.upgradeHealthAndDamage(upgradeDamage, upgradeHealth);
            }
            upgradeDamage += 0.5f;
            upgradeHealth += 0.5f;
        }

}
