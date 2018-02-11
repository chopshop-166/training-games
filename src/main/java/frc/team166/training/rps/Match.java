package frc.team166.training.rps;

import frc.team166.training.core.MatchStatus;

/**
 * The base class for all AI players
 */
public class Match {

    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        player1.setPlayerId(Player.Id.A);
        player2.setPlayerId(Player.Id.B);
    }

    public MatchStatus run() {
        return run(false);
    }

    public MatchStatus run(boolean verbose) {
        Move m1 = player1.play();
        Move m2 = player2.play();

        player1.getPlayed(player2.getPlayerId(), m2);
        player2.getPlayed(player1.getPlayerId(), m1);

        MoveComparer comp = new MoveComparer();
        switch (comp.compare(m1, m2)) {
        case 0:
            if (verbose) {
                System.out.println("The game is tied with " + m1);
            }
            return MatchStatus.Tie;
        case -1:
            if (verbose) {
                System.out.println("Player 2 wins with " + m2 + " vs " + m1);
            }
            return MatchStatus.P2;
        case 1:
            if (verbose) {
                System.out.println("Player 1 wins with " + m1 + " vs " + m2);
            }
            return MatchStatus.P1;
        }
        return MatchStatus.Error;
    }
}
