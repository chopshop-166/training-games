package frc.team166.training.tictactoe;

import frc.team166.training.core.MatchBase;
import frc.team166.training.core.MatchStatus;

/**
 * The base class for all AI players
 */
public class Match extends MatchBase<Player> {

    Id board[][] = new Id[3][3];

    public Match() {
        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Id.Empty;
            }
        }
    }

    @Override
    public void setPlayerIds() {
        player1.setPlayerId(Id.X);
        player2.setPlayerId(Id.O);
    }

    public MatchStatus run() {
        return run(false);
    }

    public MatchStatus run(boolean verbose) {
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
        Id id = p1.getPlayerId();
        Move move;
        do {
            move = p1.play();
        } while (!accept(id, move));
        p1.getPlayed(id, move);
        p2.getPlayed(id, move);
    }

    // Game status information below

    boolean accept(Id player, Move m) {
        if (m == null) {
            return false;
        }
        if (board[m.row][m.col] == Id.Empty) {
            board[m.row][m.col] = player;
            return true;
        } else {
            return false;
        }
    }

    boolean isFinished() {
        return getWinner() != MatchStatus.Error;
    }

    void printState() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    MatchStatus getWinner() {
        if (board[0][0] != Id.Empty) {
            if ((board[0][0] == board[0][1] && board[0][1] == board[0][2])
                    || (board[0][0] == board[1][0] && board[1][0] == board[2][0])
                    || (board[0][0] == board[1][1] && board[1][1] == board[2][2])) {
                return toStatus(board[0][0]);
            }
        }
        if (board[1][1] != Id.Empty) {
            if ((board[0][1] == board[1][1] && board[0][1] == board[1][2])
                    || (board[1][0] == board[1][1] && board[1][1] == board[1][2])
                    || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
                return toStatus(board[1][1]);
            }
        }
        if (board[2][2] != Id.Empty) {
            if ((board[2][0] == board[2][1] && board[2][1] == board[2][2])
                    || (board[0][2] == board[1][2] && board[1][2] == board[2][2])) {
                return toStatus(board[2][2]);
            }
        }
        boolean isTied = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Id.Empty) {
                    isTied = false;
                }
            }
        }
        if (isTied) {
            return MatchStatus.Tie;
        }
        return MatchStatus.Error;
    }

    MatchStatus toStatus(Id id) {
        switch (id) {
        case X:
            if (player1.getPlayerId() == Id.X) {
                return MatchStatus.P1;
            } else {
                return MatchStatus.P2;
            }
        case O:
            if (player1.getPlayerId() == Id.O) {
                return MatchStatus.P1;
            } else {
                return MatchStatus.P2;
            }
        default:
            return MatchStatus.Error;
        }
    }
}
