package frc.team166.training.tictactoe;

/**
 * The base class for all AI players
 */
public abstract class Player {

    enum Id {
        Empty, X, O;

        @Override
        public String toString() {
            switch (this) {
            case Empty:
                return " ";
            case X:
                return "X";
            case O:
                return "O";
            default:
                return null;
            }
        }
    }

    protected Id playerId = Id.Empty;

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
     * Determine what move the opponent made last game
     * @param move The last move the opponent made
     */
    public void setPlayerId(Id id) {
        playerId = id;
    }

    /**
     * Determine what move the opponent made last game
     */
    public Id getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
