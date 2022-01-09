package Heroes;

import SkillsAndUpgrades.Potion;
import Log.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private boolean potionUsed;
    private int numberOfSmallPotions = 0;
    private int numberOfMediumPotions = 0;
    private int numberOfBigPotions = 0;

    protected ArrayList<Potion> potions = new ArrayList<>();

    Log log = new Log();
    Scanner scanner = new Scanner(System.in);

    public void addPotion(Potion potion) {
        potions.add(potion);
        if(potion.getName().equals("Small healing potion")) {
            numberOfSmallPotions++;
        }
        else if(potion.getName().equals("Medium healing potion")) {
            numberOfMediumPotions++;
        }
        else {
            numberOfBigPotions++;
        }
    }

    private void showInventory() {
        log.info("Potions:");
        log.info("[1] Small healing potions: " + numberOfSmallPotions);
        log.info("[2] Medium healing potions: " + numberOfMediumPotions);
        log.info("[3] Big healing potions: " + numberOfBigPotions);
    }

    public void usePotion(Hero hero) {
        boolean run = true;
        String choose;
        String name = "";
        int choice = 0;
        int index = -1;
        int potionIndex = -1;

        do {
            showInventory();
            log.info("[4] Leave");
            log.userChooses();
            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }

            switch(choice) {
                case 1 -> name = "Small healing potion";
                case 2 -> name = "Medium healing potion";
                case 3 -> name = "Big healing potion";
                case 4 -> {
                    run = false;
                    potionUsed = false;
                }
            }

        } while((choice < 1 || choice > 3) && run);

        if(run) {
            for(Potion potion : potions) {
                index++;
                if (potion.getName().equals(name)) {
                    potionIndex = index;
                }
            }
            if(potionIndex != -1) {
                if(potions.get(potionIndex).getName().equals("Small healing potion")) {
                    numberOfSmallPotions--;
                }
                else if(potions.get(potionIndex).getName().equals("Medium healing potion")) {
                    numberOfMediumPotions--;
                }
                else {
                    numberOfBigPotions--;
                }
                hero.heal(potions.get(potionIndex).getHealingValue());
                potions.remove(potionIndex);
                potionUsed = true;
            }
            else {
                log.info("You don't have that potion.");
            }
        }
    }

    public boolean wasPotionUsed() {
        return potionUsed;
    }

}
