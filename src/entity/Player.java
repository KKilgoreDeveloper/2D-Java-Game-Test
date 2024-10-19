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
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    int standCounter;
    int spriteChangeCounter = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
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

        up1 = setup("coyote_up_1");
        up2 = setup("coyote_up_2");
        down1 = setup("coyote_down_1");
        down2 = setup("coyote_down_2");
        down3 = setup("coyote_down_3");
        down4 = setup("coyote_down_4");
        left1 = setup("coyote_left_1");
        left2 = setup("coyote_left_2");
        right1 = setup("coyote_right_1");
        right2 = setup("coyote_right_2");
        stand = setup("coyote_stand");

    }
    public BufferedImage setup (String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image= null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
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
            spriteCounter++;
            if(spriteCounter > 11){
                if(spriteNum==1){
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 3;
                } else if (spriteNum == 3){
                    spriteNum = 4;
                } else if (spriteNum == 4){
                    spriteNum = 5;
                } else if (spriteNum == 5){
                    spriteNum = 6;
                } else if (spriteNum == 6){
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

            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Curtain":
                    if(hasKey > 0){
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You broke in!");
                        System.out.println("Key:"+hasKey);
                    }
                    else {
                        gp.ui.showMessage("You need a key...");
                    }
                    break;
                case "Basket":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    break;
                case "Headdress":
                    gp.playSE(2);
                    speed+= 1;
                    gp.obj[i] = null;
                    break;
            }
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
                   spriteNum = 1;
               }
                break;
            case"down":
                if (spriteNum == 1 || spriteNum == 2 || spriteNum == 3 || spriteNum == 4 || spriteNum == 5 || spriteNum == 6){

                    if (spriteNum == 1){
                        image = down1;
                    }
                    if(spriteNum == 2){
                        image = down2;
                    }
                    if (spriteNum == 3){
                        image = down3;
                    }
                    if(spriteNum == 4){
                        image = down4;
                    }
                    if (spriteNum == 5){
                        image = down3;
                    }
                    if(spriteNum == 6){
                        image = down2;
                    }

                } else {
                    spriteNum = 0;
                }
                break;
            case"left":
                if (spriteNum == 1 || spriteNum == 2 || spriteNum == 3 || spriteNum == 4 || spriteNum == 5 || spriteNum == 6){
                    if (spriteNum == 1){
                        image = left1;
                    }
                    if(spriteNum == 2){
                        image = left2;
                    }
                    if (spriteNum == 3){
                        image = left1;
                    }
                    if(spriteNum == 4){
                        image = left2;
                    }
                    if (spriteNum == 5){
                        image = left1;
                    }
                    if(spriteNum == 6){
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
                    spriteNum = 1;
                }
                break;

        }
        if (spriteNum == 0){
            image = stand;
        }
        g2.drawImage(image, screenX, screenY, null);
    }
}
