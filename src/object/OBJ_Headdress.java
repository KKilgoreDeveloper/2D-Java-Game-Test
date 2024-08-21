package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Headdress extends SuperObject{
    GamePanel gp;
    public OBJ_Headdress(GamePanel gp){
        this.gp = gp;
        name = "Headdress";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/headdress.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
