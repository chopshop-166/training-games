package frc.team166.training.tictactoe;

public enum Move {
    A1(0, 0), A2(0, 1), A3(0, 2), B1(1, 0), B2(1, 1), B3(1, 2), C1(2, 0), C2(2, 1), C3(2, 2);

    Move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public final int row;
    public final int col;
}
