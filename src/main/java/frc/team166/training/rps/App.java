package frc.team166.training.rps;

import frc.team166.training.rps.players.AlwaysPaper;
import frc.team166.training.rps.players.Human;

public class App {
    public static void main(String[] args) {
        Player p1 = new AlwaysPaper();
        Player p2 = new Human();
        Match m = new Match(p1, p2);
        m.run();
    }
}
