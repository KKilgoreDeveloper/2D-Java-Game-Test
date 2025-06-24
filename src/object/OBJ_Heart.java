package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp){
        super(gp);
        name = "Heart";
        image1 = setup("/objects/heart-full");
        image2 = setup("/objects/heart-half");
        image3 = setup("/objects/heart-empty");

    }
}
