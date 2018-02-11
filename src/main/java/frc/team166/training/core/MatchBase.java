package frc.team166.training.core;

import frc.team166.training.core.MatchStatus;

/**
 * The base class for all AI players
 */
public abstract class MatchBase<Player> {

    protected Player player1;
    protected Player player2;

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        setPlayerIds();
    }

    abstract public void setPlayerIds();

    public MatchStatus run() {
        return run(false);
    }

    abstract public MatchStatus run(boolean verbose);
}
