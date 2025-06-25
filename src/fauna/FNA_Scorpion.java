package fauna;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class FNA_Scorpion extends Entity{
    public FNA_Scorpion(GamePanel gp) {
        super(gp);
        type = 2;
        faunaType = 2;
        name = "Scorpion";
        speed = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = -18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultY = solidArea.y;
        solidAreaDefaultX = solidArea.x;

        getImage();
    }
    public void getImage(){

        up1 = setup("/fauna/scorpion-left1");
        up2 = setup("/fauna/scorpion-left2");
        down1 = setup("/fauna/scorpion-right1");
        down2 = setup("/fauna/scorpion-right2");
        left1 = setup("/fauna/scorpion-left1");
        left2 = setup("/fauna/scorpion-left2");
        right1 = setup("/fauna/scorpion-right1");
        right2 = setup("/fauna/scorpion-right2");

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
}
