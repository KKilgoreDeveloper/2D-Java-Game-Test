package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Basket extends Entity {

    public OBJ_Basket(GamePanel gp){
        super(gp);
        name = "Basket";
        down1 = setup("/objects/basket",gp.tileSize,gp.tileSize);
    }
}
