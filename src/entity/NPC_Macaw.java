package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Macaw extends Entity{
    public NPC_Macaw(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage(){

        up1 = setup("/npc/macaw-up1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/macaw-up2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/macaw-down1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/macaw-down2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/macaw-left1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/macaw-left2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/macaw-right1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/macaw-right2", gp.tileSize, gp.tileSize);

    }
    public void setDialogue(){
        dialogues[0] = "Hello there young coyote,";
        dialogues[1] = "I was hoping your path would lead@you here";
    }
    public void setAction(){

        actionLockCounter++;

        if(actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; //pick number from 1 to 100

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }

    public void speak(){
        //Do character-specific stuff
        super.speak();
    }
}
