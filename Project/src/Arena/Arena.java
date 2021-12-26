package Arena;

import Enemies.*;
import Heroes.*;
import Log.*;

import java.util.ArrayList;

public class Arena {
    Log log = new Log();
    Horde horde = new Horde();
    int defeatedHordes=0;

    ArrayList<Enemy> enemies = new ArrayList<>();

    Hero hero = new Warrior("Henry");

    public void createArena() {
        do {
            horde.create(enemies, horde.getHowManyEnemies());

            for(Enemy enemy : enemies) {
                do {
                    if(hero.isAlive()) {
                        hero.attack(enemy);
                        enemy.attack(hero);
                    }
                }
                while(enemy.isAlive() && hero.isAlive());
            }

            enemies.clear();
            horde.setHowManyEnemies();
        } while(hero.isAlive());

        System.out.print(ConsoleColors.RED_UNDERLINED + "" + ConsoleColors.RED_BOLD);
        System.out.println("GAME OVER");
        System.out.println(ConsoleColors.RESET);
    }

}
