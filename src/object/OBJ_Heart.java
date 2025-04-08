package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp){
        super(gp);
        name = "Heart";
        image = setup("/objects/heart-full.png");
        image2 = setup("/objects/heart-half.png");
        image3 = setup("/objects/heart-empty.png");

    }
}
