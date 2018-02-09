package frc.team166.training.rps;

import frc.team166.training.rps.players.AlwaysPaper;
import frc.team166.training.rps.players.AlwaysRock;
import frc.team166.training.rps.players.AlwaysScissors;
import frc.team166.training.rps.players.Human;

public class App {
    public static void main(String[] args) {
        Tournament t = new Tournament(5, new AlwaysPaper(), new AlwaysRock(), new AlwaysScissors(), new AlwaysRock(),
                new AlwaysScissors(), new Human());
        t.run(true);
    }
}
