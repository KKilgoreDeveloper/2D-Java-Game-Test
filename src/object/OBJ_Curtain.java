package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Curtain extends Entity {

    public OBJ_Curtain(GamePanel gp){
        super(gp);
        name = "Curtain";
        down1 = setup("/objects/curtain",gp.tileSize,gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
}
