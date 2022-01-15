package Main;

import Entities.JillyJuice;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TitleAndEndScreen extends JPanel{
    private static String font1 = "InkFree";
    public static String titleMessage = "Attack of The Martians";
    public static String endMessage = "You Are Ded!";

    public static boolean start = false;
    private static int font = 50;

    public void drawTitle(Graphics g) {
        if(GameElements.running == false) {
            g.setColor(Color.black);
            g.setFont(new Font(font1, Font.BOLD, font));
            FontMetrics startScreenMessage = getFontMetrics((g.getFont()));
            g.drawString(titleMessage, (GameElements.SCREEN_WIDTH - startScreenMessage.stringWidth(titleMessage)) / 2, GameElements.SCREEN_HEIGHT / 2);
            g.setFont(new Font(font1, Font.BOLD, font - 10));
            FontMetrics spaceBar = getFontMetrics((g.getFont()));
            g.drawString("Press Space to Start", (GameElements.SCREEN_WIDTH - spaceBar.stringWidth("Press Space to Start")) / 2, (GameElements.SCREEN_HEIGHT / 2) + font);

        }
    }

    public void drawEnd(Graphics g) {
        if(GameElements.running == false) {
            g.setColor(Color.black);
            g.setFont(new Font(font1, Font.BOLD, font));
            FontMetrics startScreenMessage = getFontMetrics((g.getFont()));
            g.drawString(endMessage, (GameElements.SCREEN_WIDTH - startScreenMessage.stringWidth(endMessage)) / 2, GameElements.SCREEN_HEIGHT / 2);
            g.drawString("Score: " + JillyJuice.jillyJuiceDrank, (GameElements.SCREEN_WIDTH - startScreenMessage.stringWidth("Score: " + JillyJuice.jillyJuiceDrank)) / 2, (GameElements.SCREEN_HEIGHT / 2) + font);
        }
    }

    public static void titleStart() {
        if(start == true) {
            GameElements.running = true;
            GameElements.gamePlayed = true;
        }
    }

    public static class startKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                start = true;
                GameElements.gamePlayed = true;
            }
        }
    }
}

