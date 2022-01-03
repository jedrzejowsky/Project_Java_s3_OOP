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

    public void availableMoney(Hero hero) {
        System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT);
        System.out.println("Available money: " + hero.getGatheredMoney() + "$");
        System.out.print(ConsoleColors.RESET);
    }
}
