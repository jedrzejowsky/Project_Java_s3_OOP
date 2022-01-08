package Log;

import Heroes.Hero;
import Interfaces.Entity;

public class Log {

    public void info(String message) {
        System.out.println(message);
    }

    public void died(Entity entity) {
        System.out.print(ConsoleColors.RED);
        System.out.println(entity.getName() + " died.");
        System.out.print(ConsoleColors.RESET);
    }

    public void gameOver() {
        System.out.print(ConsoleColors.RED_UNDERLINED + "" + ConsoleColors.RED_BOLD);
        System.out.println("GAME OVER");
        System.out.println(ConsoleColors.RESET);
    }

    public void userChooses() {
        System.out.print(ConsoleColors.GREEN_BOLD);
        System.out.print(">> ");
        System.out.print(ConsoleColors.RESET);
    }

    public void heroMoneyAndHealth(Hero hero) {
        System.out.print(ConsoleColors.RED_BOLD_BRIGHT);
        System.out.println("Current HP: " + hero.getHealth() + " | Max HP: " + hero.getBaseHealth());
        System.out.print(ConsoleColors.RESET);
        System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT);
        System.out.println("Available money: " + hero.getGatheredMoney() + "$");
        System.out.print(ConsoleColors.RESET);
    }

    public void potionsToBuy(Hero hero) {
        if(hero.getGatheredMoney() < 5) {
            System.out.print(ConsoleColors.WHITE);
            System.out.println("[1] Small healing potion (25% HP, 5$)");
            System.out.print(ConsoleColors.RESET);
        }
        else {
            System.out.println("[1] Small healing potion (25% HP, 5$)");
        }
        if(hero.getGatheredMoney() < 8) {
            System.out.print(ConsoleColors.WHITE);
            System.out.println("[2] Medium healing potion (50% HP, 8$)");
            System.out.print(ConsoleColors.RESET);
        }
        else {
            System.out.println("[2] Medium healing potion (50% HP, 8$)");
        }
        if(hero.getGatheredMoney() < 12) {
            System.out.print(ConsoleColors.WHITE);
            System.out.println("[3] Big healing potion (75% HP, 12$)");
            System.out.print(ConsoleColors.RESET);
        }
        else {
            System.out.println("[3] Big healing potion (75% HP, 12$)");
        }
    }

    public void goblinDroppedHundred() {
        System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT);
        System.out.println("Goblin dropped 100$");
        System.out.print(ConsoleColors.RESET);
    }

}
