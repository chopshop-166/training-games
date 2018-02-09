package frc.team166.training.rps.players;

import frc.team166.training.rps.Move;
import frc.team166.training.rps.Player;

/**
 * Always return paper
 */
public class AlwaysPaper extends Player {
    /**
     * Generate a move based only on the current state
     */
    public Move play() {
        return Move.Paper;
    }
}
