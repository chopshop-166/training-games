package frc.team166.training.rps;

/**
 * The base class for all AI players
 */
public class Tournament {

    Player[] players;

    public Tournament(int numMatches, Player... players) {
        this.players = players;
    }

    public void run() {
    }
}
