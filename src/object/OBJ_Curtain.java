package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Curtain extends SuperObject{

    public OBJ_Curtain(){
        name = "Curtain";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/curtain.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
