package frc.team166.training.tictactoe.players;

import java.util.Random;

import frc.team166.training.core.TournamentReady;
import frc.team166.training.tictactoe.Move;
import frc.team166.training.tictactoe.Player;

/**
 * Replace artificial intelligence with human interaction
 * If they enter something other than a valid name, then their choice is as dumb as a rock, so return one
 */
@TournamentReady
public class RandomAI extends Player {
    Random rnd = new Random();

    @Override
    public Move play() {
        switch (rnd.nextInt(9)) {
        case 0:
            return Move.A1;
        case 1:
            return Move.A2;
        case 2:
            return Move.A3;
        case 3:
            return Move.B1;
        case 4:
            return Move.B2;
        case 5:
            return Move.B3;
        case 6:
            return Move.B1;
        case 7:
            return Move.B2;
        case 8:
            return Move.B3;
        }
        return null;
    }
}
