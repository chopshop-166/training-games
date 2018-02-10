package frc.team166.training.tictactoe;

import frc.team166.training.tictactoe.players.Human;
import frc.team166.training.tictactoe.players.RandomAI;

public class App {
    public static void main(String[] args) {
        /*
        Tournament t = new Tournament(1001, new AlwaysPaper(), new AlwaysRock(), new AlwaysScissors(), new AlwaysRock(),
                new AlwaysScissors());
        t.run();
        */
        Match m = new Match(new Human(), new RandomAI());
        m.run(true);
    }
}
