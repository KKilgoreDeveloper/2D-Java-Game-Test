package entity;

import main.CollisionCheck;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp. screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
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

        up1 = setup("/player/coyote_up_1");
        up2 = setup("/player/coyote_up_2");
        down1 = setup("/player/coyote_down_1");
        down2 = setup("/player/coyote_down_2");
        left1 = setup("/player/coyote_left_1");
        left2 = setup("/player/coyote_left_2");
        right1 = setup("/player/coyote_right_1");
        right2 = setup("/player/coyote_right_2");

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

        //CHECK OBJECT COLLISION
        int objIndex = gp.cCheck.checkObject (this, true);
        pickUpObject(objIndex);

        //If collision is false, player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
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
        } else {
            standCounter++;
            if (standCounter == 20){
                spriteNum = 1;
                standCounter = 0;
            }
        }

    }

    public void pickUpObject(int i){
        if(i != 999){


        }
    }

    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch(direction) {
            case"up":
               if (spriteNum == 1 || spriteNum == 2){
                   if (spriteNum == 1){
                       image = up1;
                   }
                   if(spriteNum == 2){
                       image = up2;
                   }

               } else {
                   spriteNum = 0;
               }
                break;
            case"down":
                if (spriteNum == 1 || spriteNum == 2){

                    if (spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }


                } else {
                    spriteNum = 0;
                }
                break;
            case"left":
                if (spriteNum == 1 || spriteNum == 2){
                    if (spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                } else {
                    spriteNum = 0;
                }
                break;
            case"right":
                if (spriteNum == 1 || spriteNum == 2){
                    if (spriteNum == 1){
                        image = right1;
                    }
                    if(spriteNum == 2){
                        image = right2;
                    }
                } else {
                    spriteNum = 0;
                }
                break;

        }
        if (spriteNum == 0){
            image = stand;
        }
        g2.drawImage(image, screenX, screenY, null);
    }
}
