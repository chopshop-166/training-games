package frc.team166.training.rps;

import frc.team166.training.core.MatchBase;
import frc.team166.training.core.MatchStatus;

/**
 * A single instance of Rock Paper Scissors
 */
public class Match extends MatchBase<Player> {

    @Override
    public void setPlayerIds() {
        player1.setPlayerId(Id.A);
        player2.setPlayerId(Id.B);
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
