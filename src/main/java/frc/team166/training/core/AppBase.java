package frc.team166.training.core;

public class AppBase {
    final static String ROOT_PLAYER_PATH = "frc.team166.training.tictactoe.players";

    public static Object initializePlayer(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException ex) {
            System.err.println("Could not initialize " + clazz + ": InstantiationException");
            return null;
        } catch (IllegalAccessException ex) {
            System.err.println("Could not initialize " + clazz + ": IllegalAccessException");
            return null;
        }
    }

    public static Class<?> lookupClass(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not initialize " + name + ": ClassNotFoundException");
            return null;
        }
    }
}
