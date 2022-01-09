package Arena;

import Enemies.*;
import Heroes.*;
import Interfaces.Boss;
import Log.*;
import SkillsAndUpgrades.Merchant;

import java.util.ArrayList;

public class Arena {
    int wave = 1;

    ArrayList<Enemy> enemies = new ArrayList<>();

    Log log = new Log();
    Horde horde = new Horde();
    Merchant merchant = new Merchant();
    Combat combat = new Combat();

    public void createArena(String className, String characterName) {
        Hero hero = createHero(className, characterName);
        do {
            horde.create(enemies, wave);
            horde.upgrade(enemies);
            log.waveNumber(wave);

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
                hero.hordeDefeated();
                wave++;
                merchant.upgrade(hero);
                horde.setHowManyEnemies(wave);
            }
        } while(hero.isAlive());

        hero.statistics();
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
