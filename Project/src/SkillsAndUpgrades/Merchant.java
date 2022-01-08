package SkillsAndUpgrades;

import Heroes.Hero;
import Log.Log;

import java.util.Scanner;

public class Merchant {
    private boolean alreadyMet = false;
    Scanner scanner = new Scanner(System.in);
    Upgrade upgrade = new Upgrade();
    Log log = new Log();

    public void upgrade(Hero hero) {
        if(!alreadyMet) {
            upgrade.skillsToTeach();
            System.out.println("Merchant: Hello! I can teach you how to fight or sell you some potions.");
            alreadyMet = true;
        }
        else {
            System.out.println("Merchant: You know the drill.");
        }

        String choose;
        int choice = 0;
        boolean run = true;

        do {
            log.info("What you want: ");
            log.heroMoneyAndHealth(hero);
            log.info("[1] Buy potion");
            log.info("[2] Learn new skill");
            log.info("[3] Upgrade skill");
            log.info("[4] Upgrade health (+1.0HP, 5$)");
            log.info("[5] Next Wave");

            log.userChooses();
            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }

            switch(choice) {
                case 1 -> upgrade.buyPotion(hero);
                case 2 -> upgrade.learnNewSkill(hero);
                case 3 -> upgrade.upgradeSkill(hero);
                case 4 -> upgrade.upgradeHealth(hero);
                case 5 -> run = false;
            }
        } while(run);
    }

}
