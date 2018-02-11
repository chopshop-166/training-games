package frc.team166.training.ab;

import frc.team166.training.core.MatchStatus;
import frc.team166.training.core.TournamentBase;

/**
 * A tournament takes many players and returns only one
 * Only the winners survive, and at the end there can be only one
 */
public class Tournament extends TournamentBase<Player> {

    public Tournament(int numMatches) {
        super(numMatches);
    }

    @Override
    protected Player runMatchup(Player p1, Player p2, boolean verbose) {
        Match match = new Match();
        match.setPlayers(p1, p2);
        int wins1 = 0;
        int wins2 = 0;
        for (int i = 0; (i < numMatches || wins1 == wins2) && (i < numMatches * 2); i++) {
            MatchStatus st = match.run(verbose);
            switch (st) {
            case P1:
                wins1++;
                break;
            case P2:
                wins2++;
                break;
            default:
                break;
            }
        }

        return showResults(p1, p2, wins1, wins2);
    }
}
