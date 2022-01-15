package Entities;

import Main.GameElements;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class Enemy {
    public static int numOfEnemies;
    //public static int enemyX;
    //public static int enemyY;

    public static ArrayList<Integer> enemyX = new ArrayList<Integer>();
    public static ArrayList<Integer> enemyY = new ArrayList<Integer>();

    static Random random = new Random();

    public static void addEnemy() {
        numOfEnemies += 1;
        enemyX.add(GameElements.SCREEN_WIDTH);
        enemyY.add(random.nextInt((int) GameElements.SCREEN_HEIGHT / GameElements.UNIT_SIZE) * GameElements.UNIT_SIZE);
    }

    public static void enemyDraw(Graphics g) {
        for(int i = 0; i < numOfEnemies; i++) {
            g.setColor(Color.red);
            g.fillOval(enemyX.get(i), enemyY.get(i), GameElements.UNIT_SIZE, GameElements.UNIT_SIZE);
        }
    }

    public static void checkEnemy() {
        for(int i = 0; i < numOfEnemies; i++) {
            if(enemyX.get(i) == GameElements.x[0] && enemyY.get(i) == GameElements.y[0]) {
                GameElements.running = false;
            }

            switch(GameElements.direction) {
                case 'R':
                    if(enemyX.get(i) == GameElements.x[0] + GameElements.UNIT_SIZE && enemyY.get(i) == GameElements.y[0]) {
                        GameElements.running = false;
                        break;
                    }
            }

            if(enemyX.get(i) == 0) {
                enemyX.set(i, GameElements.SCREEN_WIDTH);
                enemyY.set(i, random.nextInt((int) GameElements.SCREEN_HEIGHT / GameElements.UNIT_SIZE) * GameElements.UNIT_SIZE);
            }
        }
    }
}