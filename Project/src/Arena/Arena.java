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

    public void createArena(String className, String characterName) {
        Hero hero = createHero(className, characterName);
        do {
            horde.create(enemies, defeatedHordes+1);
            horde.upgrade(enemies);
            log.waveNumber(defeatedHordes+1);

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
                horde.setHowManyEnemies(defeatedHordes);
            }
        } while(hero.isAlive());

        //statystyki przerzucic pozniej zeby pokazywalo z innej klasy
        log.info("Hordes defeated: " + defeatedHordes);
        log.info("Money gathered: " + hero.getGatheredMoney());
        log.gameOver();
    }

    public Hero createHero(String className, String characterName) {
        if(className.equals("Warrior")) {
            return new Warrior(characterName);
        }
        else if(className.equals("Mage")) {
            return new Mage(characterName);
        }
        else {
            return new Rogue(characterName);
        }
    }

}
