package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    //Scaling
    final int scale = 3;
    public final int tileSize= originalTileSize * scale; //48x48tile
    public final int maxScreenCol =16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionCheck cCheck = new CollisionCheck(this);
    public Player player = new Player(this,keyH);



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
       double drawInterval = 1000000000/FPS; // 0.01666... seconds
       double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){

            //Update: Update information, such as character position
            update();

            //Draw: draw the screen with the updated information
            repaint();

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; //converted from nano to milisecons
                long sleepTime = Math.max(0, (long) remainingTime); // Ensure sleepTime is non-negative
                Thread.sleep(sleepTime);

                nextDrawTime += drawInterval;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}
