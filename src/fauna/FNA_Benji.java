package fauna;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class FNA_Benji extends Entity {

    public FNA_Benji(GamePanel gp) {
        super(gp);
        type = 2;
        faunaType = 1;
        name = "Benji";
        speed = 1;
        maxLife = 2;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 9;
        solidArea.width = 21;
        solidArea.height = 15;
        solidAreaDefaultY = solidArea.y;
        solidAreaDefaultX = solidArea.x;

        getImage();
    }
    public void getImage(){

        up1 = setup("/fauna/benji-left",gp.tileSize,gp.tileSize);
        up2 = setup("/fauna/benji-left",gp.tileSize,gp.tileSize);
        down1 = setup("/fauna/benji-right",gp.tileSize,gp.tileSize);
        down2 = setup("/fauna/benji-right",gp.tileSize,gp.tileSize);
        left1 = setup("/fauna/benji-left",gp.tileSize,gp.tileSize);
        left2 = setup("/fauna/benji-left",gp.tileSize,gp.tileSize);
        right1 = setup("/fauna/benji-right",gp.tileSize,gp.tileSize);
        right2 = setup("/fauna/benji-right",gp.tileSize,gp.tileSize);

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
