package Entities;

import Main.GameElements;

import java.awt.*;
import java.util.Random;

public class JillyJuice {
    public static int jillyJuiceDrank = 0;
    public static int hiddenScore;
    private static int jjX;
    private static int jjY;

    static Random random = new Random();

    public static void jillyJuiceDraw(Graphics g) {
        g.setColor(new Color(111, 109, 3));
        g.fillOval(jjX, jjY, GameElements.UNIT_SIZE, GameElements.UNIT_SIZE);
    }

    public static void checkJJ() {
        if ((GameElements.x[0] == jjX) && (GameElements.y[0] == jjY)) {
            jillyJuiceDrank += 1;
            hiddenScore += 1;
            newJJ();
        }
    }

    public static void newJJ() {
        JillyJuice.jjX = random.nextInt((int) GameElements.SCREEN_WIDTH / GameElements.UNIT_SIZE) * GameElements.UNIT_SIZE;
        JillyJuice.jjY = random.nextInt((int) GameElements.SCREEN_HEIGHT / GameElements.UNIT_SIZE) * GameElements.UNIT_SIZE;
    }
}
