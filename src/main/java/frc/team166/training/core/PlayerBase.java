package frc.team166.training.core;

/**
 * The base class for all AI players
 */
public abstract class PlayerBase<Id, Move> {

    protected Id playerId;

    /**
     * Generate a move based only on the current state
     */
    public abstract Move play();

    /**
     * Determine what move a player made last
     * This will be called when a successful move is played by either player
     * Your own moves will be reported via this interface
     * @param player The player who made the move
     * @param move The last move the opponent made
     */
    public void getPlayed(Id player, Move move) {

    }

    /**
     * Set the current player's ID
     * @param move The last move the opponent made
     */
    public void setPlayerId(Id id) {
        playerId = id;
    }

    /**
     * Get this player's ID
     */
    public Id getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
