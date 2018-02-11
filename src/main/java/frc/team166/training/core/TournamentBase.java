package frc.team166.training.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A tournament takes many players and returns only one
 * Only the winners survive, and at the end there can be only one
 */
public abstract class TournamentBase<Player extends PlayerBase<?, ?>> {

    protected int numMatches;
    protected Player[] players;

    public TournamentBase(int numMatches) {
        this.numMatches = numMatches;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
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

    abstract protected Player runMatchup(Player p1, Player p2, boolean verbose);
}
