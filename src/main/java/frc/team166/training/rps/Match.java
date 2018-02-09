package frc.team166.training.rps;

/**
 * The base class for all AI players
 */
public class Match {

    enum Status {
        Tie, P1, P2, Error
    }

    Player player1;
    Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        player1.setPlayerNumber(1);
        player2.setPlayerNumber(2);
    }

    public Status run() {
        return run(false);
    }

    public Status run(boolean verbose) {
        Move m1 = player1.play();
        Move m2 = player2.play();

        player1.getPlayed(m2);
        player2.getPlayed(m1);

        MoveComparer comp = new MoveComparer();
        switch (comp.compare(m1, m2)) {
        case 0:
            if (verbose) {
                System.out.println("The game is tied with " + m1);
            }
            return Status.Tie;
        case -1:
            if (verbose) {
                System.out.println("Player 2 wins with " + m2 + " vs " + m1);
            }
            return Status.P2;
        case 1:
            if (verbose) {
                System.out.println("Player 1 wins with " + m1 + " vs " + m2);
            }
            return Status.P1;
        }
        return Status.Error;
    }
}
