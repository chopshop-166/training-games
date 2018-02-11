package frc.team166.training.tictactoe;

/**
 * The player ID
 */
public enum Id {
    Empty, X, O;

    @Override
    public String toString() {
        switch (this) {
        case Empty:
            return " ";
        case X:
            return "X";
        case O:
            return "O";
        default:
            return null;
        }
    }
}
