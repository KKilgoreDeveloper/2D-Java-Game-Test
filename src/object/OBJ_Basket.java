package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Basket extends SuperObject{

    public OBJ_Basket(){
        name = "Basket";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/basket.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
