package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Curtain extends Entity {

    public OBJ_Curtain(GamePanel gp){
        super(gp);
        name = "Curtain";
        down1 = setup("/objects/curtain.png");
    }
}
