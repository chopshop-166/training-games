package frc.team166.training.tictactoe;

import frc.team166.training.core.TournamentReady;
import java.util.Arrays;
import java.util.Set;
import org.reflections.Reflections;

public class App {
    final static String ROOT_PLAYER_PATH = "frc.team166.training.tictactoe.players";

    public static void main(String[] args) {
        Player[] tournamentPlayers;
        if (args.length == 0) {
            final Reflections reflections = new Reflections(ROOT_PLAYER_PATH);
            Set<Class<?>> allTournamentReady = reflections.getTypesAnnotatedWith(TournamentReady.class);
            tournamentPlayers = allTournamentReady.stream().map(c -> {
                try {
                    return c.newInstance();
                } catch (InstantiationException ex) {
                    System.err.println("Could not initialize " + c + ": InstantiationException");
                    return null;
                } catch (IllegalAccessException ex) {
                    System.err.println("Could not initialize " + c + ": IllegalAccessException");
                    return null;
                }
            }).filter(p -> p != null).toArray(Player[]::new);
        } else {
            tournamentPlayers = Arrays.stream(args).map(n -> {
                try {
                    return Class.forName(ROOT_PLAYER_PATH + "." + n).newInstance();
                } catch (InstantiationException ex) {
                    System.err.println("Could not initialize " + n + ": InstantiationException");
                    return null;
                } catch (IllegalAccessException ex) {
                    System.err.println("Could not initialize " + n + ": IllegalAccessException");
                    return null;
                } catch (ClassNotFoundException ex) {
                    System.err.println("Could not initialize " + n + ": ClassNotFoundException");
                    return null;
                }
            }).filter(p -> p != null).toArray(Player[]::new);
        }
        Tournament tournament = new Tournament(5, tournamentPlayers);
        tournament.run(true);
    }
}
