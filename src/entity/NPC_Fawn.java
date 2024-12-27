package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Fawn extends Entity{
    public NPC_Fawn(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;
    }

    public void getPlayerImage(){

        up1 = setup("/NPC/fawn-up1");
        up2 = setup("/NPC/fawn-up2");
        down1 = setup("/NPC/fawn-down1");
        down2 = setup("/NPC/fawn-down2");
        left1 = setup("/NPC/fawn-left1");
        left2 = setup("/NPC/fawn-left2");
        right1 = setup("/NPC/fawn-right1");
        right2 = setup("/NPC/fawn-right2");

    }

}
