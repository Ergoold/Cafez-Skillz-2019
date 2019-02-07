package bots;

import elf_kingdom.Castle;
import elf_kingdom.Elf;
import elf_kingdom.Game;

/**
 * class that controls the elves
 */
class Elves {
    public static boolean has_created_portal = false;
    /**
     * Gives orders to my elves.
     *
     * @param game - the current game state
     */
    static void handleElves(Game game) {
        // Get enemy castle
        Castle enemyCastle = game.getEnemyCastle();
        // Go over all the living elves.
        for (Elf elf : game.getMyLivingElves()) {
            if (elf.inAttackRange(enemyCastle)) {
                if (!has_created_portal) {
                    buildPortal(game, elf);
                    has_created_portal = true;
                } else {
                    elf.attack(enemyCastle);
                }
            } else {
                elf.moveTo(enemyCastle);
            }
        }
    }

    /**
     *
     * tells an elf to build a portal if in range of castle
     *
     * @param game - the current game state
     */
    public static void buildPortal(Game game) {
        Castle enemyCastle = game.getEnemyCastle();
        for (Elf elf : game.getAllLivingElves()) {
            if (elf.canBuildPortal() && elf.inAttackRange(enemyCastle)) {
                elf.buildPortal();
                return;
            }
        }
    }

    /**
     *
     * tells a certain elf to build a portal if in range of castle
     *
     * @param game - the current game state
     * @param elf - elv to build portal
     */
    public static void buildPortal(Game game, Elf elf) {
        Castle enemyCastle = game.getEnemyCastle();
        if (elf.canBuildPortal() && elf.inAttackRange(enemyCastle)) {
            elf.buildPortal();
        }
    }
}
