package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Opossum extends Entity {
    public NPC_Opossum(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage(){

        up1 = setup("/npc/opossum-up1");
        up2 = setup("/npc/opossum-up2");
        down1 = setup("/npc/opossum-down1");
        down2 = setup("/npc/opossum-down2");
        left1 = setup("/npc/opossum-left1");
        left2 = setup("/npc/opossum-left2");
        right1 = setup("/npc/opossum-right1");
        right2 = setup("/npc/opossum-right2");

    }
    public void setDialogue(){
        dialogues[0] = "It's my birthday!";
        dialogues[1] = "Happy Birthday to me!";
        dialogues[2] = "I'm still waiting for my friends to make@it";
        dialogues[3] = "Anytime now.";
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
