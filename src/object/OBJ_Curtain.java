package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Curtain extends SuperObject{
    GamePanel gp;
    public OBJ_Curtain(GamePanel gp){
        this.gp = gp;
        name = "Curtain";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/curtain.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
