package bots;

import elf_kingdom.Castle;
import elf_kingdom.Elf;
import elf_kingdom.Game;

class Elves {
    /**
     * Gives orders to my elves.
     *
     * @param game - the current game state
     */
    static void handleElves(Game game) {
        // Get enemy castle
        Castle enemyCastle = game.getEnemyCastle();
        // Go over all the living elves.
        for (Elf elf : game.getMyLivingElves())
        {
            // Try to attack enemy castle, if not move to it.
            if (elf.inAttackRange(enemyCastle)) {
                // Attack!
                elf.attack(enemyCastle);
                // Print a message.
                System.out.println("elf " + elf + " attacks " + enemyCastle);
            } else {
                // Move to enemy castle!
                elf.moveTo(enemyCastle);
                // Print a message.
                System.out.println("elf " + elf + " moves to " + enemyCastle);
            }
        }
    }
}
