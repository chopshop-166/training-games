package frc.team166.training.ab.players;

import frc.team166.training.core.TournamentReady;
import frc.team166.training.ab.Move;
import frc.team166.training.ab.Player;

/**
 * Always return paper
 */
@TournamentReady
public class AlwaysAlly extends Player {
    /**
     * Generate a move based only on the current state
     */
    @Override
    public Move play() {
        return Move.Ally;
    }
}
