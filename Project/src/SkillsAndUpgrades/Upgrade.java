package SkillsAndUpgrades;

import Heroes.*;
import Log.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Upgrade {
    private ArrayList<BuyableSkill> learnableSkillsWarrior = new ArrayList<>();
    private ArrayList<BuyableSkill> learnableSkillsMage = new ArrayList<>();
    private ArrayList<BuyableSkill> learnableSkillsRogue = new ArrayList<>();
    Log log = new Log();
    Scanner scanner = new Scanner(System.in);

    public void upgradeHealth(Hero hero) {
        if(hero.getGatheredMoney() >= 5) {
            hero.upgradeHealth(0.5f, 5);
            System.out.println("Health upgraded.");
        }
        else {
            System.out.println("You don't have enough money");
        }
    }

    public void upgradeSkill(Hero hero) {
        System.out.println("Which skill to upgrade:");
        boolean run = true;
        String choose;
        int choice = 0;

        if(hero instanceof Warrior) {
            do {
                int index = 1;
                for(Skill skill: hero.getAllSkills()) {
                    log.info("[" + index + "] " + skill.getSkillName());
                    index++;
                }

                log.info("[" + index + "] Leave");
                log.userChooses();
                try {
                    choose = scanner.nextLine();
                    choice = Integer.parseInt(choose);
                } catch(NumberFormatException e) {
                    System.out.print("");
                }

                if(choice == index) run = false;

            } while((choice < 1) || (choice > hero.getAllSkills().size()) && run);
        }

        /*else if(hero instanceof Mage) {
            System.out.println("spells");
        }
        else if(hero instanceof Rogue) {
            System.out.println("");
        }*/

        if(hero.getGatheredMoney() >= 10 && run) {
            hero.getAllSkills().get(choice-1).upgradeDamage(0.5f);
            hero.buy(10);
        }
        else if(hero.getGatheredMoney()<10){
            log.info("Not enough money!");
        }
    }

    public void learnNewSkill(Hero hero) {
        boolean run = true;
        String choose;
        int choice = 0;

        System.out.println("Which skill would you like to learn:");
        if(hero instanceof Warrior) {
            do {
                int index = 1;
                for(BuyableSkill skill: learnableSkillsWarrior) {
                    if(skill.getSkillPrice() > hero.getGatheredMoney()) {
                        System.out.print(ConsoleColors.WHITE);
                        System.out.println("[" + index + "] " + skill.getSkillName() + ", " + skill.getSkillDamage() + " DMG " + "(" + skill.getSkillPrice() + "$)");
                        System.out.print(ConsoleColors.RESET);
                    }
                    else {
                        System.out.println("[" + index + "] " + skill.getSkillName() + ", " + skill.getSkillDamage() + " DMG " + "(" + skill.getSkillPrice() + "$)");
                    }
                    index++;
                }

                log.info("[" + index + "] Leave");
                log.userChooses();
                try {
                    choose = scanner.nextLine();
                    choice = Integer.parseInt(choose);
                } catch(NumberFormatException e) {
                    System.out.print("");
                }

                if(choice == index) run = false;

            } while((choice < 1) || (choice > learnableSkillsWarrior.size()) && run);

           if(run) {
               log.info("Learned " + learnableSkillsWarrior.get(choice-1).getSkillName() + "!");
               hero.buySkill(learnableSkillsWarrior.get(choice-1), learnableSkillsWarrior.get(choice-1).getSkillPrice());
               learnableSkillsWarrior.remove(choice-1);
           }
           else {
               log.info("Not enough money!");
           }
        }

        /*else if(hero instanceof Mage) {

        }
        else if(hero instanceof Rogue) {

        }*/
    }

    //dodaje skille do listy, uzyc tylko raz
    public void skillsToTeach() {
        learnableSkillsWarrior.add(new BuyableSkill("Attack3", 7, 20));
        learnableSkillsWarrior.add(new BuyableSkill("Attack4", 8, 30));
        learnableSkillsWarrior.add(new BuyableSkill("Attack5", 5.5f, 15));
        //learnableSkillsMage.add();
        //learnableSkillsRogue.add();
    }
}
