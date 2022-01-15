package Entities;

import Main.GameElements;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player {

    public static void playerDraw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(GameElements.x[0], GameElements.y[0], GameElements.UNIT_SIZE, GameElements.UNIT_SIZE);
    }

    public static void move() {
        switch(GameElements.direction) {
            case 'L':
                GameElements.x[0] = GameElements.x[0] - GameElements.UNIT_SIZE;
                break;

            case 'R':
                GameElements.x[0] = GameElements.x[0] + GameElements.UNIT_SIZE;
                break;

            case 'U':
                GameElements.y[0] = GameElements.y[0] - GameElements.UNIT_SIZE;
                break;

            case 'D':
                GameElements.y[0] = GameElements.y[0] + GameElements.UNIT_SIZE;
                break;
        }
    }

    public static class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    GameElements.direction = 'L';
                    break;

                case KeyEvent.VK_D:
                    GameElements.direction = 'R';
                    break;

                case KeyEvent.VK_W:
                    GameElements.direction = 'U';
                    break;

                case KeyEvent.VK_S:
                    GameElements.direction = 'D';
                    break;
            }
        }
    }
}