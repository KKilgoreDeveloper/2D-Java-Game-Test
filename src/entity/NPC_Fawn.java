package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Fawn extends Entity{
    public NPC_Fawn(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;

        getImage();
        setDialogue();
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
    public void setDialogue(){
        dialogues[0] = "Hello! I haven't seen you around before.";
        dialogues[1] = "I HOPE YOU'RE NOT A DANGER *hehe*";
        dialogues[2] = "Where are you from???";
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

        if (dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }

}
