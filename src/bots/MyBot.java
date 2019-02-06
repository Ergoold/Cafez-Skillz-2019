package bots;
import elf_kingdom.*;


/**
 * This is an example for a bot.
 */
public class MyBot implements SkillzBot {
    /**
     * Makes the bot run a single turn.
     *
     * @param game - the current game state.
     */
    @Override
    public void doTurn(Game game) {
        // Give orders to my elves.
        handleElves(game);
        // Give orders to my portals.
        handlePortals(game);
    }

    /**
     * Gives orders to my elves.
     *
     * @param game - the current game state
     */
    private void handleElves(Game game) {
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

    /**
     * Gives orders to my portals.
     *
     * @param game - the current game state
     */
    private void handlePortals(Game game) {
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
