package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[] [];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[50];
        mapTileNum = new int [gp.maxWorldCol] [gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/worldmap.txt");
    }
    public void getTileImage() {

        //grass
        setup(0,"DGrs", false);
        setup(14,"GrsVar1", false);
        setup(15,"GrsVar2", false);
        setup(16,"ancient", false);
        setup(17,"rock", false);
        setup(18,"skull", false);

        //adobe wall
        setup(1,"adobewallupdated", true);
        setup(19,"adobecorner-leftup",true);
        setup(20,"adobecorner-leftdown",true);
        setup(21,"adobecorner-rightup",true);
        setup(22,"adobecorner-rightdown",true);
        setup(23,"adobeinnercorner-right",true);
        setup(24,"adobeinnercorner-left",true);
        setup(34,"adobeinnercorner-upright",true);
        setup(35,"adobeinnercorner-upleft",true);
        setup(30,"dirtcorner-up", true);
        setup(31,"dirtcorner-down", true);
        setup(32,"dirtcorner-left", true);
        setup(33,"dirtcorner-right", true);
        //water
        setup(2,"water", false);
        setup(3,"wateredge-down", true);
        setup(4,"wateredge-up", true);
        setup(5,"wateredge-left", true);
        setup(6,"wateredge-right", true);
        setup(7,"watercorner-leftdown", true);
        setup(8,"watercorner-rightdown", true);
        setup(9,"watercorner-leftup", true);
        setup(10,"watercorner-rightup", true);
        //dirt
        setup(11,"dirt", false);
        setup(25,"dirtcorner-leftdown", false);
        setup(26,"dirtcorner-leftup", false);
        setup(27,"dirtcorner-rightdown", false);
        setup(28,"dirtcorner-rightup", false);
        setup(29,"dirtcorner-right", true);
        //sand
        setup(12,"sand", false);
        //plants
        setup(13,"maguey", true);
    }
    public void setup(int index, String imageName, boolean collision){
        UtilityTool uTool = new UtilityTool();
        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt (numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {

        }
    }
    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;


            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
