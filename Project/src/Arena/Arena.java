package Arena;

import Enemies.*;
import Heroes.*;
import Interfaces.Boss;
import Log.*;
import SkillsAndUpgrades.Merchant;

import java.util.ArrayList;

public class Arena {
    Log log = new Log();
    Horde horde = new Horde();
    Merchant merchant = new Merchant();
    Combat combat = new Combat();
    int defeatedHordes=0;

    ArrayList<Enemy> enemies = new ArrayList<>();

    Hero hero = new Mage("Henry");

    public void createArena() {
        do {
            horde.create(enemies, defeatedHordes+1);
            log.info("Wave: " + (defeatedHordes+1));

            do {
                combat.chooseAction(hero, enemies);
                if(!enemies.isEmpty()) {
                    if(enemies.get(0) instanceof Boss) {
                        enemies.get(0).attack(hero);
                    }
                    else {
                        combat.attackingEnemy(enemies).attack(hero);
                    }
                }
            } while(hero.isAlive() && !enemies.isEmpty());

            if(hero.isAlive()) {
                defeatedHordes++;
                merchant.upgrade(hero);
                horde.setHowManyEnemies();
            }
        } while(hero.isAlive());

        //statystyki przerzucic pozniej zeby pokazywalo z innej klasy
        log.info("Hordes defeated: " + defeatedHordes);
        log.info("Money gathered: " + hero.getGatheredMoney());
        log.gameOver();
    }

}
