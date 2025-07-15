package entity;

import main.GamePanel;

import java.util.Random;

public class TEO_Itz extends Entity{
    public TEO_Itz(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;


        getImage();
        setDialogue();
    }

    public void getImage(){

        up1 = setup("/npc/Itzpapalotl-left", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/Itzpapalotl-left", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/Itzpapalotl-right", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Itzpapalotl-right", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/Itzpapalotl-left", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/Itzpapalotl-left", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/Itzpapalotl-right", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/Itzpapalotl-right", gp.tileSize, gp.tileSize);

    }
    public void setDialogue(){
        dialogues[0] = "Hello you.";
        dialogues[1] = "Do you know who I am?";
        dialogues[2] = "Do you know what I am?";
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
