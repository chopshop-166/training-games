package frc.team166.training.rps;

import java.util.Comparator;

public class MoveComparer implements Comparator<Move> {

    @Override
    public int compare(Move o1, Move o2) {
        switch (o1) {
        case Rock:
            switch (o2) {
            case Rock:
                return 0;
            case Paper:
                return -1;
            case Scissors:
                return 1;
            }
        case Paper:
            switch (o2) {
            case Rock:
                return 1;
            case Paper:
                return 0;
            case Scissors:
                return -1;
            }
        case Scissors:
            switch (o2) {
            case Rock:
                return -1;
            case Paper:
                return 1;
            case Scissors:
                return 0;
            }
        }
        return 0;
    }

}
