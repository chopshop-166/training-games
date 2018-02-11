package frc.team166.training.ab.players;

import java.util.Scanner;

import frc.team166.training.ab.Id;
import frc.team166.training.ab.Move;
import frc.team166.training.ab.Player;

/**
 * Replace artificial intelligence with human interaction
 */
public class Human extends Player {
    /**
     * Read a move from stdin
     * Annotation is used because we have a scanner that shouldn't be closed
     */
    @SuppressWarnings("resource")
    @Override
    public Move play() {
        System.out.print("Player " + getPlayerId() + ": enter a move to make: ");
        try {
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();
            return Move.valueOf(choice);
        } catch (IllegalArgumentException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    @Override
    public void getPlayed(Id player, Move move) {
        System.out.println(player + " chose to " + move);
    }
}
