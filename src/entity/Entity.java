package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    public GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, stand;
    public String direction = "down";

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public int hurtCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex = 0;
    public BufferedImage image1, image2, image3;
    public String name;
    public boolean collision = false;
    public int type; // 0 = player, 1 = npc, 2 = fauna
    public int faunaType; // 0 = passive, 1 = defensive, 2 = offensive;

    // CHARACTER STATUS
    public int maxLife;
    public int life;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void setAction() {}
    public void speak() {

        if (dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }
    public void update() {
        setAction();

        collisionOn = false;
        gp.cCheck.checkTile(this);
        gp.cCheck.checkObject(this,false);
        gp.cCheck.checkEntity(this, gp.npc);
        gp.cCheck.checkEntity(this, gp.fauna);
        boolean contactPlayer = gp.cCheck.checkPlayer(this);

        if (this.type == 2 && contactPlayer == true){
            if (gp.player.invincible == false){
                if (this.faunaType == 2){
                    //offensive fauna can walk into player and give damage
                    gp.player.life -= 1;
                    gp.player.invincible = true;
                }
            }
        }

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
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
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
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
    public BufferedImage setup (String imagePath, int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image= null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, width, height);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
