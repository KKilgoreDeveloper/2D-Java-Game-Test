package main;

import object.OBJ_Basket;
import object.OBJ_Key;
import object.OBJ_Curtain;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        //Keys
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 6 * gp.tileSize;
        gp.obj[0].worldY = 39 * gp.tileSize;

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 5 * gp.tileSize;
        gp.obj[1].worldY = 6 * gp.tileSize;

        //Curtains
        gp.obj[2] = new OBJ_Curtain();
        gp.obj[2].worldX = 40 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;
        gp.obj[3] = new OBJ_Curtain();
        gp.obj[3].worldX = 41 * gp.tileSize;
        gp.obj[3].worldY = 8 * gp.tileSize;

        gp.obj[4] = new OBJ_Curtain();
        gp.obj[4].worldX = 6 * gp.tileSize;
        gp.obj[4].worldY = 8 * gp.tileSize;
        gp.obj[5] = new OBJ_Curtain();
        gp.obj[5].worldX = 39 * gp.tileSize;
        gp.obj[5].worldY = 34 * gp.tileSize;

        //Baskets
        gp.obj[6] = new OBJ_Basket();
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 36 * gp.tileSize;
        gp.obj[7] = new OBJ_Basket();
        gp.obj[7].worldX = 43 * gp.tileSize;
        gp.obj[7].worldY = 32 * gp.tileSize;
    }
}
