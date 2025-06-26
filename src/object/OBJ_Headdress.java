package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Headdress extends Entity {

    public OBJ_Headdress(GamePanel gp){
        super(gp);
        name = "Headdress";
        down1 = setup("/objects/headdress",gp.tileSize,gp.tileSize);
    }
}
