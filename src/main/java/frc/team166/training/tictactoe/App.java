package frc.team166.training.tictactoe;

import frc.team166.training.tictactoe.players.Crash;

public class App {
    public static void main(String[] args) {
        /*
        Tournament t = new Tournament(1001, new AlwaysPaper(), new AlwaysRock(), new AlwaysScissors(), new AlwaysRock(),
                new AlwaysScissors());
        t.run();
        */
        Match m = new Match(new Crash(), new Crash());
        m.accept(Player.Id.X, Move.A1);
        m.accept(Player.Id.X, Move.B1);
        m.printState();
        System.out.println(m.getWinner());
        m.accept(Player.Id.X, Move.C1);
        m.printState();
        System.out.println(m.getWinner());
    }
}
