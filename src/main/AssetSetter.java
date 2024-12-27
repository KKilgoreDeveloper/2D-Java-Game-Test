package main;

import entity.NPC_Fawn;
import entity.NPC_Panther;
import object.OBJ_Basket;
import object.OBJ_Headdress;
import object.OBJ_Key;
import object.OBJ_Curtain;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    }
    public void setNPC() {

        gp.npc[0] = new NPC_Fawn(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;

        gp.npc[1] = new NPC_Panther(gp);
        gp.npc[1].worldX = gp.tileSize*24;
        gp.npc[1].worldY = gp.tileSize*24;
    }
}
