package Main;

import Entities.Enemy;
import Entities.JillyJuice;
import Entities.Player;
import Music.PlaySong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class GamePanel extends JPanel implements ActionListener {
    private static TitleAndEndScreen TextScreens = new TitleAndEndScreen();

    Timer timer;
    Random random;

    GamePanel(){
        random = new Random();

        this.setPreferredSize(new Dimension(GameElements.SCREEN_WIDTH, GameElements.SCREEN_HEIGHT));
        this.setBackground(new Color(139, 54, 4));
        this.setFocusable(true);
        this.addKeyListener(new Player.MyKeyAdapter());
        this.addKeyListener(new TitleAndEndScreen.startKey());

        startGame();
    }

    public void startGame(){
        JillyJuice.newJJ();
        Enemy.addEnemy();

        timer = new Timer(GameElements.DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if(GameElements.running == true) {
            if(GameElements.i == 1) {
                PlaySong.playBackgroundSong();
            }

            for(int i = 0; i < GameElements.SCREEN_HEIGHT / GameElements.UNIT_SIZE; i++) {
                g.drawLine(i * GameElements.UNIT_SIZE, 0, i * GameElements.UNIT_SIZE, GameElements.SCREEN_HEIGHT);
                g.drawLine(0, i * GameElements.UNIT_SIZE, GameElements.SCREEN_WIDTH, i * GameElements.UNIT_SIZE);
            }


            if(JillyJuice.hiddenScore == 5) {
                Enemy.addEnemy();
                JillyJuice.hiddenScore = 0;
            }

            //Enemy.addEnemy(); // Giant amount of enemies in the game

            Enemy.enemyDraw(g);

            for(int i = 0; i < Enemy.enemyX.size(); i++) {
                Enemy.enemyX.set(i, Enemy.enemyX.get(i) - GameElements.UNIT_SIZE);
            }

            // Jilly Juice
            JillyJuice.jillyJuiceDraw(g);

            // Player
            Player.playerDraw(g);

            //System.out.println(Enemy.enemyXList.length);
            //System.out.println(Enemy.enemyYList.length);

            // Score
            g.setFont(new Font("Arial", Font.BOLD, GameElements.UNIT_SIZE));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Jilly Juice Drank: " + JillyJuice.jillyJuiceDrank, 0, (int) ((GameElements.SCREEN_HEIGHT / GameElements.UNIT_SIZE)) * GameElements.UNIT_SIZE);
        }
        if (GameElements.running == false) {
            if(GameElements.i < 2 && GameElements.gamePlayed == false) {
                TextScreens.drawTitle(g);
            }

            if(GameElements.i == 0) {
                PlaySong.playTitleSong();
            }

            if(GameElements.i >= 1 && GameElements.gamePlayed == true) {
                TextScreens.drawEnd(g);
            }

            if(GameElements.i == 2) {
                PlaySong.backgroundMusic.stop();
                PlaySong.playTitleSong();
            }
        }
    }

    public void checkCollisions() {
        // Collision with left side
        if(GameElements.x[0] < 0){
            GameElements.running = false;
        }

        // Collision with right side
        if(GameElements.x[0] >= GameElements.SCREEN_WIDTH) {
            GameElements.running = false;
        }

        // Collision with top border
        if(GameElements.y[0] < 0) {
            GameElements.running = false;
        }

        // Collision with bottom border
        if(GameElements.y[0] >= GameElements.SCREEN_HEIGHT) {
            GameElements.running = false;
        }

        if(!GameElements.running) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GameElements.running == true) {
            Enemy.checkEnemy();
            JillyJuice.checkJJ();
            checkCollisions();
            Player.move();
        } else { TitleAndEndScreen.titleStart(); }
        repaint();
    }
}
