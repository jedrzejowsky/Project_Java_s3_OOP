package Skills;

import Interfaces.Entity;
import Log.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat {

    int chosenAttack;
    Scanner scanner = new Scanner(System.in);
    Log log = new Log();

    //wybieranie skilla podczas atakowania
    public float chooseSkill(ArrayList<Skill> skills) {
        int index = 1;
        chosenAttack = 0;
        log.info("Available attacks:");

        for(Skill skill : skills) {
            log.info("[" + index + "] " + skill.getSkillName() + " " + skill.getSkillDamage() + " DMG");
            index++;
        }

        do {
            log.info("Choose: ");
            chosenAttack = scanner.nextInt();
        } while(chosenAttack<1 || chosenAttack>skills.size());

        return skills.get(chosenAttack-1).getSkillDamage();
    }

    public int getChosenAttack() {
        return chosenAttack-1;
    }

    public void combatLog(Entity enemy, Skill skill) {
        log.info(enemy.getName() + " got hit for: " + skill.getSkillDamage() + " DMG. Current health " + enemy.getHealth());
    }

}
