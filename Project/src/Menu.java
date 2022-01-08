import Arena.Arena;
import Log.Log;

import java.util.Scanner;

public class Menu {
    String className;
    String characterName;

    Log log = new Log();
    Scanner scanner = new Scanner(System.in);
    Arena arena = new Arena();

    public void run() {
        String choose;
        int choice = 0;

        do {
            log.info("[1] Start game");
            log.info("[2] Quit");
            log.userChooses();

            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }
        } while(choice < 1 || choice > 2);

        if(choice == 1) {
            startGame();
        }
    }

    public void startGame() {
        heroChoice();
        arena.createArena(className, characterName);
    }

    public void heroChoice() {
        String choose;
        String characterName;
        int choice = 0;

        do {
            log.info("Select class:");
            log.info("[1] Warrior");
            log.info("[2] Mage");
            log.info("[3] Rogue");
            log.userChooses();

            try {
                choose = scanner.nextLine();
                choice = Integer.parseInt(choose);
            } catch(NumberFormatException e) {
                System.out.print("");
            }
        } while(choice < 1 || choice > 3);

        log.info("Name your character:");
        log.userChooses();
        characterName = scanner.nextLine();

        if(choice == 1) {
            className = "Warrior";
        }
        else if(choice == 2) {
            className = "Mage";
        }
        else {
            className = "Rogue";
        }
        this.characterName = characterName;
    }
}
