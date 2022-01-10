package Enemies;

import Log.Log;

public class Bestiary {

    public void showEnemies() {
        Log log = new Log();

        log.info("");
        log.infoYellow("Normal enemies:");
        log.enemyInfoRed("Ghul     HP:12 | DMG:6");
        log.enemyInfoBlue("Goblin   HP:5  | DMG:3");
        log.enemyInfoRed("Orc      HP:14 | DMG:7");
        log.enemyInfoBlue("Skeleton HP:13 | DMG:5");
        log.enemyInfoRed("Zombie   HP:10 | DMG:5");
        log.info("");
        log.infoYellow("Bosses:");
        log.enemyInfoRed("Cutie  HP: 100 | skills:");
        log.enemyInfoRed("  Toss DMG: 10 | Trunk Attack DMG: 15 | Trample DMG: 17.5");
        log.enemyInfoBlue("Kayran HP: 150 | skills:");
        log.enemyInfoBlue("  Rock Throw DMG: 15 | Tentacle Hit DMG: 18.5 | Ground Slam DMG: 20.5");
        log.enemyInfoRed("Hag    HP: 220 | skills:");
        log.enemyInfoRed("  Pot Attack DMG: 12 | Spill Boiling Water DMG: 16.5 | Tenderize DMG: 25");
        log.enemyInfoBlue("Scrapbeak       HP: 275 | skills:");
        log.enemyInfoBlue("  Concertina Throw DMG: 12.5 | Shovel Slash DMG: 16.5 | Hammer Hit DMG: 26");
        log.enemyInfoRed("Flying Dutchman HP: 300 | skills:");
        log.enemyInfoRed("  Exploding Barrel DMG: 18 | Cannonball Shot DMG: 22 | Volley DMG: 30.5");
    }

}
