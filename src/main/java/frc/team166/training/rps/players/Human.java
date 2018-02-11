package frc.team166.training.rps.players;

import java.util.Scanner;

import frc.team166.training.rps.Move;
import frc.team166.training.rps.Player;

/**
 * Replace artificial intelligence with human interaction
 * If they enter something other than a valid name, then their choice is as dumb as a rock, so return one
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
}
