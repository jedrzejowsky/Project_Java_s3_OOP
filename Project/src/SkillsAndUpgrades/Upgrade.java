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
            hero.upgradeHealth(1.0f, 5);
            log.info("Health upgraded.");
            log.info("Max HP: " + hero.getBaseHealth());
        }
        else {
            log.info("You don't have enough money");
        }
    }

    public void buyPotion(Hero hero) {
        log.info("Which potion would you like to buy:");
        boolean run = true;
        String choose;
        int choice = 0;
        int price = 0;

        do {
            log.potionsToBuy(hero);
            log.info("[4] Leave");
            log.userChooses();

            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }

            if(choice == 4) run = false;

        } while((choice < 1) || (choice > 3) && run);

        if(run) {
            switch(choice) {
                case 1 -> price = 5;
                case 2 -> price = 8;
                case 3 -> price = 12;
            }

            if(hero.getGatheredMoney() >= price) {
                hero.buy(price);
                switch(choice) {
                    case 1 -> hero.getInventory().addPotion(new Potion("Small healing potion", 25));
                    case 2 -> hero.getInventory().addPotion(new Potion("Medium healing potion", 50));
                    case 3 -> hero.getInventory().addPotion(new Potion("Big healing potion", 75));
                }
            }
            else {
                log.info("You don't have that much money!");
            }
        }
    }

    public void upgradeSkill(Hero hero) {
        log.info("Which skill to upgrade:");
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
        else if(hero instanceof Mage) {
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
        else if(hero instanceof Rogue) {
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

        if(hero.getGatheredMoney() >= 10 && run) {
            hero.getAllSkills().get(choice-1).upgradeDamage(2);
            hero.buy(10);
        }
        else if(hero.getGatheredMoney() < 10 && run){
            log.info("Not enough money!");
        }
        else if(!run) {
            log.info("");
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
                        log.info("[" + index + "] " + skill.getSkillName() + ", " + skill.getSkillDamage() + " DMG " + "(" + skill.getSkillPrice() + "$)");
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
                if(learnableSkillsWarrior.get(choice-1).getSkillPrice() <= hero.getGatheredMoney()) {
                    log.info("Learned " + learnableSkillsWarrior.get(choice-1).getSkillName() + "!");
                    hero.buySkill(learnableSkillsWarrior.get(choice-1), learnableSkillsWarrior.get(choice-1).getSkillPrice());
                    learnableSkillsWarrior.remove(choice-1);
                }
                else {
                    log.info("Not enough money!");
                }
            }
            else {
                log.info("");
            }
        }
        else if(hero instanceof Mage) {
            do {
                int index = 1;
                for(BuyableSkill skill: learnableSkillsMage) {
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

            } while((choice < 1) || (choice > learnableSkillsMage.size()) && run);

            if(run) {
                if(learnableSkillsMage.get(choice-1).getSkillPrice() <= hero.getGatheredMoney()) {
                    log.info("Learned " + learnableSkillsMage.get(choice-1).getSkillName() + "!");
                    hero.buySkill(learnableSkillsMage.get(choice-1), learnableSkillsMage.get(choice-1).getSkillPrice());
                    learnableSkillsMage.remove(choice-1);
                }
                else {
                    log.info("Not enough money!");
                }
            }
            else {
                log.info("");
            }

        }
        else if(hero instanceof Rogue) {
            do {
                int index = 1;
                for(BuyableSkill skill: learnableSkillsRogue) {
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

            } while((choice < 1) || (choice > learnableSkillsRogue.size()) && run);

            if(run) {
                if(learnableSkillsRogue.get(choice-1).getSkillPrice() <= hero.getGatheredMoney()) {
                    log.info("Learned " + learnableSkillsRogue.get(choice-1).getSkillName() + "!");
                    hero.buySkill(learnableSkillsRogue.get(choice-1), learnableSkillsRogue.get(choice-1).getSkillPrice());
                    learnableSkillsRogue.remove(choice-1);
                }
                else {
                    log.info("Not enough money!");
                }
            }
            else {
                log.info("");
            }

        }
    }

    //dodaje skille do listy, uzyc tylko raz
    public void skillsToTeach() {
        learnableSkillsWarrior.add(new BuyableSkill("Axe Throw", 20, 20));
        learnableSkillsWarrior.add(new BuyableSkill("Spinning Attack", 30, 27));
        learnableSkillsWarrior.add(new BuyableSkill("Decisive Strike", 50.5f, 38));
        learnableSkillsMage.add(new BuyableSkill("Lightning Spell", 35, 27));
        learnableSkillsMage.add(new BuyableSkill("Dragon Breath", 50, 36));
        learnableSkillsMage.add(new BuyableSkill("Word Of Power", 70, 45));
        learnableSkillsRogue.add(new BuyableSkill("Fire Arrow", 25, 25));
        learnableSkillsRogue.add(new BuyableSkill("Dancing Daggers", 35, 30));
        learnableSkillsRogue.add(new BuyableSkill("Backstab", 60, 43));
    }

}
