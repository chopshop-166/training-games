package frc.team166.training.rps;

/**
 * The player ID
 */
public enum Id {
    None, A, B;

    @Override
    public String toString() {
        switch (this) {
        case None:
            return " ";
        case A:
            return "A";
        case B:
            return "B";
        default:
            return null;
        }
    }
}
