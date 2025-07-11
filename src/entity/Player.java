package entity;

import main.CollisionCheck;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collection;

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

        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }
    public void getPlayerImage(){

        up1 = setup("/player/coyote_up_1", gp.tileSizeP, gp.tileSizeP);
        up2 = setup("/player/coyote_up_2", gp.tileSizeP, gp.tileSizeP);
        down1 = setup("/player/coyote_down_1", gp.tileSizeP, gp.tileSizeP);
        down2 = setup("/player/coyote_down_2", gp.tileSizeP, gp.tileSizeP);
        left1 = setup("/player/coyote_left_1", gp.tileSizeP, gp.tileSizeP);
        left2 = setup("/player/coyote_left_2", gp.tileSizeP, gp.tileSizeP);
        right1 = setup("/player/coyote_right_1", gp.tileSizeP, gp.tileSizeP);
        right2 = setup("/player/coyote_right_2", gp.tileSizeP, gp.tileSizeP);

    }

    public void update(){

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true){

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
        if(keyH.enterPressed == true){

        }

        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cCheck.checkTile(this);

        //CHECK OBJECT COLLISION
        int objIndex = gp.cCheck.checkObject (this, true);
        pickUpObject(objIndex);

        //CHECK NPC COLLISION
        int npcIndex = gp.cCheck.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //CHECK FAUNA COLLISION
        int faunaIndex = gp.cCheck.checkEntity(this, gp.fauna);
        contactFauna(faunaIndex);


        //CHECK EVENT
        gp.eHandler.checkEvent();

        //If collision is false, player can move
        if (collisionOn == false && keyH.enterPressed == false) {
            switch (direction) {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }
        gp.keyH.enterPressed = false;

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

        //this needs to be outside of key if statement!
        if (invincible == true){
            invincibleCounter++;
            if (invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void pickUpObject(int i){
        if(i != 999){


        }
    }

    public void interactNPC (int i){
        if (i != 999){
            if(gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
            gp.keyH.enterPressed = false;
        }
    }

    public void contactFauna(int i){
        if (i != 999){
            if (invincible == false){
                //player walks into fauna without invincibility
                if (gp.fauna[i].faunaType == 1){
                    //defensive fauna can give damage
                    life -= 1;
                    invincible = true;
                }
                if (gp.fauna[i].faunaType == 2){
                    //offensive fauna can give damage
                    life -= 1;
                    invincible = true;
                }
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
        if (invincible == true && invincibleCounter < 60){
            if (hurtCounter < 25){
                hurtCounter += 9;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            }
            if (hurtCounter > 25){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
                hurtCounter = 0;
            }
        }

        g2.drawImage(image, screenX, screenY, null);

        //Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        //DEBUG
        //g2.setFont(new Font("Arial",Font.PLAIN,26 ));
        //g2.setColor(Color.WHITE);
        //g2.drawString("invincible: " + invincibleCounter, 10, 400);
    }
}
