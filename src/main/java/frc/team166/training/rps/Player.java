package frc.team166.training.rps;

/**
 * The base class for all AI players
 */
public abstract class Player {

    protected int playerNumber = 0;

    /**
     * Generate a move based only on the current state
     */
    public abstract Move play();

    /**
     * Determine what move the opponent made last game
     * @param move The last move the opponent made
     */
    public void getPlayed(Move m) {

    }

    /**
     * Determine what move the opponent made last game
     * @param move The last move the opponent made
     */
    public void setPlayerNumber(int num) {
        playerNumber = num;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
