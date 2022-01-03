package Arena;

import Enemies.Enemy;
import Interfaces.Entity;
import Log.*;
import SkillsAndUpgrades.Skill;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    private int chosenSkill;
    Scanner scanner = new Scanner(System.in);
    Log log = new Log();

    //wybieranie przeciwnika do zaatakowania
    public Enemy chooseEnemy(ArrayList<Enemy> enemies) {
        String choose;
        int chosenEnemy = 0;

        do {
            int index = 1;
            log.info("Choose target:");
            for(Enemy enemy: enemies) {
                log.info("[" + index + "] " + enemy.getName() + " " + enemy.getHealth() + " HP");
                index++;
            }

            log.userChooses();
            try {
                choose = scanner.nextLine();
                chosenEnemy = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }
        } while((chosenEnemy < 1) || (chosenEnemy > enemies.size()));

        return enemies.get(chosenEnemy-1);
    }

    //wybieranie skilla podczas atakowania
    public float chooseSkill(ArrayList<Skill> skills) {
        String choose;
        chosenSkill = 0;

        do {
            int index = 1;
            log.info("Available attacks:");
            for(Skill skill : skills) {
                log.info("[" + index + "] " + skill.getSkillName() + " " + skill.getSkillDamage() + " DMG");
                index++;
            }

            log.userChooses();
            try {
                choose = scanner.nextLine();
                chosenSkill = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }
        } while((chosenSkill < 1) || (chosenSkill > skills.size()));

        return skills.get(chosenSkill-1).getSkillDamage();
    }

    public int getChosenSkill() {
        return chosenSkill-1;
    }

    public void combatLog(Entity enemy, Skill skill) {
        if(enemy.getHealth()>0) {
            log.info(enemy.getName() + " got hit for: " + skill.getSkillDamage() + " DMG. Current health " + enemy.getHealth());
        }
    }

    //losowanie przeciwnika ktory zaatakuje
    public Enemy attackingEnemy(ArrayList<Enemy> enemies) {
        Random random = new Random();
        int chosenEnemy = random.nextInt(enemies.size());

        return enemies.get(chosenEnemy);
    }

}
