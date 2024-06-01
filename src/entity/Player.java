package entity;

import main.CollisionCheck;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp. screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.width = 32;
        solidArea.height = 32;
        solidArea.x = 8;
        solidArea.y = 16;


        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/coyote_right_2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){

        if(keyH.upPressed == true){
            direction = "up";
        }
        if(keyH.downPressed == true){
            direction = "down";
        }
        if(keyH.leftPressed == true){
            direction = "left";
        }
        if(keyH.rightPressed == true){
            direction = "right";
        }

        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cCheck.checkTile(this);
        //If collision is false, player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 11){
                if(spriteNum==1){
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch(direction) {
            case"up":
                if (spriteNum == 1){
                    image = up1;
            }
               if(spriteNum == 2){
                   image = up2;
               }
                break;
            case"down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case"left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case"right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
