package bots;

import elf_kingdom.Game;
import elf_kingdom.Portal;

class Portals {
    /**
     * Gives orders to my portals.
     *
     * @param game - the current game state
     */
    static void handlePortals(Game game) {
        // Go over all of my portals.
        for (Portal portal : game.getMyPortals()) {
            // If the portal can summon a lava giant - do that.
            if (portal.canSummonLavaGiant()) {
                // Summon the lava giant.
                portal.summonLavaGiant();
                // Print a message.
                System.out.println("portal " + portal + " summons a lava giant");
            }
        }
    }

}
