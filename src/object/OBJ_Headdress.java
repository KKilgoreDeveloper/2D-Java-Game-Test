package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Headdress extends SuperObject{
    public OBJ_Headdress(){
        name = "Headdress";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/headdress.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
