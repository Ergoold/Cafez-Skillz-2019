package bots;

import elf_kingdom.Game;
import elf_kingdom.Portal;

/**
 * class that controls the portals
 */
class Portals {
    /**
     * Gives orders to my portals.
     *
     * @param game - the current game state
     */
    static void handlePortals(Game game) {
        int numOfPortals = game.getMyPortals().length;
        if (numOfPortals == 0) {
            Elves.buildPortal(game);
        }
        Portal portal = game.getMyPortals()[numOfPortals - 1];
        if (portal.canSummonLavaGiant() && MyBot.turns % 3 == 0) {
            portal.summonLavaGiant();
        }
    }
}
