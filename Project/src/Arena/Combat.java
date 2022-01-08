package Arena;

import Enemies.Enemy;
import Heroes.*;
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

    //atak lub uzycie potiona
    public void chooseAction(Hero hero, ArrayList<Enemy> enemies) {
        String choose;
        int choice = 0;
        boolean usedAttack = false;

        do {
            log.info("");
            log.info("What you want to do:");
            log.info("[1] Attack");
            log.info("[2] Use potion");

            log.userChooses();
            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }

            switch(choice) {
                case 1 -> {
                    hero.attack(enemies, chooseEnemy(enemies));
                    usedAttack = true;
                }
                case 2 -> hero.getInventory().usePotion(hero);
            }

        } while(choice<1 || choice>2);

        if(!hero.getInventory().wasPotionUsed() && !enemies.isEmpty() && !usedAttack) {
            hero.attack(enemies, chooseEnemy(enemies));
        }
    }

}
