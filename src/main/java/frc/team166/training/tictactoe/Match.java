package frc.team166.training.tictactoe;

/**
 * The base class for all AI players
 */
public class Match {

    enum Status {
        Tie, P1, P2, Error
    }

    Player player1;
    Player player2;
    Player.Id board[][] = new Player.Id[3][3];

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        player1.setPlayerId(Player.Id.X);
        player2.setPlayerId(Player.Id.O);

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Player.Id.Empty;
            }
        }
    }

    public Status run() {
        return run(false);
    }

    public Status run(boolean verbose) {
        while (!isFinished()) {
            // Player 1's turn
            makeMove(player1, player2, verbose);

            if (!isFinished()) {
                // Player 2's turn
                makeMove(player2, player1, verbose);
            }
        }

        if (verbose) {
            printState();
            switch (getWinner()) {
            case P1:
                System.out.println("Player 1 Wins");
                break;
            case P2:
                System.out.println("Player 2 Wins");
                break;
            case Tie:
                System.out.println("Game was tied");
                break;
            default:
                break;
            }
        }

        return getWinner();
    }

    void makeMove(Player p1, Player p2, boolean verbose) {
        if (verbose) {
            printState();
        }
        Player.Id id = p1.getPlayerId();
        Move move;
        do {
            move = p1.play();
        } while (!accept(id, move));
        p1.getPlayed(id, move);
        p2.getPlayed(id, move);
    }

    // Game status information below

    boolean accept(Player.Id player, Move m) {
        if (m == null) {
            return false;
        }
        if (board[m.row][m.col] == Player.Id.Empty) {
            board[m.row][m.col] = player;
            return true;
        } else {
            return false;
        }
    }

    boolean isFinished() {
        return getWinner() != Status.Error;
    }

    void printState() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    Status getWinner() {
        if (board[0][0] != Player.Id.Empty) {
            if ((board[0][0] == board[0][1] && board[0][1] == board[0][2])
                    || (board[0][0] == board[1][0] && board[1][0] == board[2][0])
                    || (board[0][0] == board[1][1] && board[1][1] == board[2][2])) {
                return toStatus(board[0][0]);
            }
        }
        if (board[1][1] != Player.Id.Empty) {
            if ((board[0][1] == board[1][1] && board[0][1] == board[1][2])
                    || (board[1][0] == board[1][1] && board[1][1] == board[1][2])
                    || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
                return toStatus(board[1][1]);
            }
        }
        if (board[2][2] != Player.Id.Empty) {
            if ((board[2][0] == board[2][1] && board[2][1] == board[2][2])
                    || (board[0][2] == board[1][2] && board[1][2] == board[2][2])) {
                return toStatus(board[2][2]);
            }
        }
        boolean isTied = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Player.Id.Empty) {
                    isTied = false;
                }
            }
        }
        if (isTied) {
            return Status.Tie;
        }
        return Status.Error;
    }

    Status toStatus(Player.Id id) {
        switch (id) {
        case X:
            if (player1.getPlayerId() == Player.Id.X) {
                return Status.P1;
            } else {
                return Status.P2;
            }
        case O:
            if (player1.getPlayerId() == Player.Id.O) {
                return Status.P1;
            } else {
                return Status.P2;
            }
        default:
            return Status.Error;
        }
    }
}
