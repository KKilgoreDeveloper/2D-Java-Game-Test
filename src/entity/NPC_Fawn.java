package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Fawn extends Entity{
    public NPC_Fawn(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;

        getImage();
    }

    public void getImage(){

        up1 = setup("/npc/fawn-up1");
        up2 = setup("/npc/fawn-up2");
        down1 = setup("/npc/fawn-down1");
        down2 = setup("/npc/fawn-down2");
        left1 = setup("/npc/fawn-left1");
        left2 = setup("/npc/fawn-left2");
        right1 = setup("/npc/fawn-right1");
        right2 = setup("/npc/fawn-right2");

    }
    public void setAction(){

        Random random = new Random();
        int i = random.nextInt(100)+1; //pick number from 1 to 100

        if(i <= 25) {
            direction = "up";
        }
        if(i > 25 && i <= 50) {
            direction = "down";
        }
        if(i > 50 && i <= 75) {
            direction = "left";
        }
        if(i > 75 && i <= 100) {
            direction = "right";
        }
    }

}
