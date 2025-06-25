package main;

import entity.NPC_Fawn;
import entity.NPC_Macaw;
import entity.NPC_Opossum;
import entity.NPC_Panther;
import fauna.FNA_Scorpion;
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

        gp.obj[0] = new OBJ_Curtain(gp);
        gp.obj[0].worldX = gp.tileSize*6;
        gp.obj[0].worldY = gp.tileSize*8;
    }
    public void setNPC() {

        gp.npc[0] = new NPC_Fawn(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;

        gp.npc[1] = new NPC_Panther(gp);
        gp.npc[1].worldX = gp.tileSize*24;
        gp.npc[1].worldY = gp.tileSize*24;

        gp.npc[2] = new NPC_Macaw(gp);
        gp.npc[2].worldX = gp.tileSize*34;
        gp.npc[2].worldY = gp.tileSize*25;

        gp.npc[3] = new NPC_Opossum(gp);
        gp.npc[3].worldX = gp.tileSize*13;
        gp.npc[3].worldY = gp.tileSize*23;
    }
    public void setFauna() {

        gp.npc[0] = new FNA_Scorpion(gp);
        gp.npc[0].worldX = gp.tileSize*30;
        gp.npc[0].worldY = gp.tileSize*19;
    }
}
