package frc.team166.training.rps.players;

import frc.team166.training.core.TournamentReady;
import frc.team166.training.rps.Move;
import frc.team166.training.rps.Player;

/**
 * Always return scissors
 */
@TournamentReady
public class AlwaysScissors extends Player {
    /**
     * Generate a move based only on the current state
     */
    @Override
    public Move play() {
        return Move.Scissors;
    }
}
