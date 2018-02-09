package frc.team166.training.rps;

public enum Move {
    Rock, Paper, Scissors;

    public String toEmoji() {
        switch (this) {
        case Rock:
            return "✊";
        case Paper:
            return "✋";
        case Scissors:
            return "✌";
        }
        return null;
    }
}
