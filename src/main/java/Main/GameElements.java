package Main;

public class GameElements {
    public static final int SCREEN_HEIGHT = 600;
    public static final int SCREEN_WIDTH = 600;
    public static final int UNIT_SIZE = 25;
    public static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    public static final int[] y = new int[GAME_UNITS];
    public static final int[] x = new int[GAME_UNITS];
    public static final int DELAY = 75;

    public static boolean running = false;
    public static char direction = 'R';

    public static int i = 0;
    public static boolean gamePlayed = false;
}