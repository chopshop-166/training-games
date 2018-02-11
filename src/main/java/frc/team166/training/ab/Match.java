package frc.team166.training.ab;

import frc.team166.training.core.MatchBase;
import frc.team166.training.core.MatchStatus;

/**
 * A single instance of the AB Game
 */
public class Match extends MatchBase<Player> {

    @Override
    public void setPlayerIds() {
        player1.setPlayerId(Id.A);
        player2.setPlayerId(Id.B);
    }

    public MatchStatus run(boolean verbose) {
        int score1 = 3;
        int score2 = 3;
        int numRounds = 0;

        while (numRounds < 20 && (0 < score1 && score1 < 9 && 0 < score2 && score2 < 9)) {
            if (verbose) {
                System.out.println("Player " + player1.getPlayerId() + ": " + score1);
                System.out.println("Player " + player2.getPlayerId() + ": " + score2);
            }
            Move m1 = player1.play();
            Move m2 = player2.play();

            player1.getPlayed(player2.getPlayerId(), m2);
            player2.getPlayed(player1.getPlayerId(), m1);

            if (m1 == Move.Ally && m2 == Move.Ally) {
                score1 += 2;
                score2 += 2;
                numRounds = 0;
            } else if (m1 == Move.Ally && m2 == Move.Betray) {
                score1 -= 2;
                score2 += 3;
                numRounds = 0;
            } else if (m1 == Move.Betray && m2 == Move.Ally) {
                score1 += 3;
                score2 -= 2;
                numRounds = 0;
            } else {
                // Scores stay the same
                numRounds++;
            }

        }

        if (score1 <= 0 && score2 <= 0) {
            if (verbose) {
                System.out.println("Both players hit 0 points");
            }
            return MatchStatus.Tie;
        }
        if (score1 >= 9 && score2 >= 9) {
            if (verbose) {
                System.out.println("Both players hit 9 points");
            }
            return MatchStatus.Tie;
        }
        if (score1 <= 0 && score2 > 0) {
            if (verbose) {
                System.out.println("Player 2 wins with " + score2 + " points vs Player 1's " + score1);
            }
            return MatchStatus.P2;
        }
        if (score2 <= 0 && score1 > 0) {
            if (verbose) {
                System.out.println("Player 1 wins with " + score1 + " points vs Player 2's " + score2);
            }
            return MatchStatus.P1;
        }
        if (score1 >= 9) {
            if (verbose) {
                System.out.println("Player 1 wins with " + score1 + " points vs Player 2's " + score2);
            }
            return MatchStatus.P1;
        }
        if (score2 >= 9) {
            if (verbose) {
                System.out.println("Player 2 wins with " + score2 + " points vs Player 1's " + score1);
            }
            return MatchStatus.P2;
        }
        return MatchStatus.Error;
    }
}
