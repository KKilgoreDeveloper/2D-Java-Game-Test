package entity;

import main.GamePanel;

public class NPC_Fawn extends Entity{
    public NPC_Fawn(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;

        getImage();
    }

    public void getImage(){

        up1 = setup("/npc/fawn-up1");
        up2 = setup("/npc/fawn-up2");
        down1 = setup("/npc/fawn-down1");
        down2 = setup("/npc/fawn-down2");
        left1 = setup("/npc/fawn-left1");
        left2 = setup("/npc/fawn-left2");
        right1 = setup("/npc/fawn-right1");
        right2 = setup("/npc/fawn-right2");

    }

}
