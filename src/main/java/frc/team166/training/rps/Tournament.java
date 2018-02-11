package frc.team166.training.rps;

import frc.team166.training.core.MatchStatus;
import frc.team166.training.core.TournamentBase;

/**
 * A tournament takes many players and returns only one
 * Only the winners survive, and at the end there can be only one
 */
public class Tournament extends TournamentBase<Player> {

    public Tournament(int numMatches, Player... players) {
        super(numMatches, players);
    }

    @Override
    protected Player runMatchup(Player p1, Player p2, boolean verbose) {
        Match match = new Match();
        match.setPlayers(p1, p2);
        int wins = 0;
        for (int i = 0; (i < numMatches || wins == 0) && (i < numMatches * 2); i++) {
            MatchStatus st = match.run(verbose);
            switch (st) {
            case P1:
                wins++;
                break;
            case P2:
                wins--;
                break;
            default:
                break;
            }
        }

        if (wins > 0) {
            System.out.println("Player 1 (" + p1 + ") wins against Player 2 (" + p2 + ")");
            return p1;
        } else if (wins < 0) {
            System.out.println("Player 2 (" + p2 + ") wins against Player 1 (" + p1 + ")");
            return p2;
        } else {
            System.out.println("Player 1 (" + p1 + ") and Player 1 (" + p2 + ") are ill-behaved, removing both");
            return null;
        }
    }
}
