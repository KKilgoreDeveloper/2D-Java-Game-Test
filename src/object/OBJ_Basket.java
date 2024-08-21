package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Basket extends SuperObject{

    GamePanel gp;
    public OBJ_Basket(GamePanel gp){
        this.gp = gp;
        name = "Basket";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/basket.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
