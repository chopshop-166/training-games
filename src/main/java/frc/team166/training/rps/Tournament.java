package frc.team166.training.rps;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A tournament takes many players and returns only one
 * Only the winners survive, and at the end there can be only one
 */
public class Tournament {

    int numMatches;
    Player[] players;

    public Tournament(int numMatches, Player... players) {
        this.numMatches = numMatches;
        this.players = players;
        for (Player p : players) {
            System.out.println(p);
        }
    }

    public void run() {
        run(false);
    }

    public void run(boolean verbose) {
        List<Player> roundPlayers = new LinkedList<Player>(Arrays.asList(players));
        List<Player> nextRoundPlayers = new LinkedList<Player>();
        int round = 1;
        while (roundPlayers.size() > 1) {
            System.out.println("--- ROUND " + round + " ---");
            while (roundPlayers.size() > 1) {
                Player p1 = roundPlayers.remove(0);
                Player p2 = roundPlayers.remove(0);
                Player winner = runMatchup(p1, p2, verbose);
                if (winner != null) {
                    nextRoundPlayers.add(winner);
                }
            }
            if (roundPlayers.size() == 1) {
                System.out.println("Player " + roundPlayers.get(0) + " gets a bye");
                nextRoundPlayers.add(roundPlayers.remove(0));
            }
            roundPlayers = nextRoundPlayers;
            Collections.shuffle(roundPlayers);
            nextRoundPlayers = new LinkedList<Player>();
            round++;
        }
        if (roundPlayers.size() == 0) {
            System.out.println("There is no winner, blame misbehaving AI");
        } else {
            System.out.println("Tournament winner is " + roundPlayers.get(0));
        }
    }

    Player runMatchup(Player p1, Player p2, boolean verbose) {
        System.out.println("Creating match with " + p1 + " and " + p2);
        Match match = new Match(p1, p2);
        int wins = 0;
        for (int i = 0; (i < numMatches || wins == 0) && (i < numMatches * 2); i++) {
            Match.Status st = match.run(verbose);
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
