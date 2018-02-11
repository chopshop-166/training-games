package frc.team166.training.rps;

import frc.team166.training.core.AppBase;
import frc.team166.training.core.TournamentReady;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;
import org.reflections.Reflections;

public class App extends AppBase {
    final static String ROOT_PLAYER_PATH = "frc.team166.training.rps.players";

    public static void main(String[] args) {
        Stream<Class<?>> playerClasses;
        if (args.length == 0) {
            final Reflections reflections = new Reflections(ROOT_PLAYER_PATH);
            Set<Class<?>> allTournamentReady = reflections.getTypesAnnotatedWith(TournamentReady.class);
            playerClasses = allTournamentReady.stream();
        } else {
            playerClasses = Arrays.stream(args).map(n -> lookupClass(ROOT_PLAYER_PATH + "." + n));
        }
        Stream<Player> tournamentPlayers = playerClasses.map(AppBase::initializePlayer).map(Player.class::cast)
                .filter(p -> p != null);
        Tournament tournament = new Tournament(5);
        tournament.setPlayers(tournamentPlayers.toArray(Player[]::new));
        tournament.run(true);
    }
}
