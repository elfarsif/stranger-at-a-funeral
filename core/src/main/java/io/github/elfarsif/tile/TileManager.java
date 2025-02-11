package io.github.elfarsif.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    public int[][] map;
    GamePanel gamePanel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        tile = new Tile[50];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldMap.txt");
    }

    private void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = new Texture("tiles/grass-plain.png");

            tile[1] = new Tile();
            tile[1].image = new Texture("tiles/dirt.png");
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = new Texture("tiles/water-plain.png");
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = new Texture("tiles/top-border.png");
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = new Texture("tiles/left-top-border.png");
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = new Texture("tiles/left-border.png");
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = new Texture("tiles/border-convex-bottom-left.png");
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = new Texture("tiles/right-border.png");
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = new Texture("tiles/border-convex-bottom-right.png");
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = new Texture("tiles/border-convex-bottom-left-water.png");
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = new Texture("tiles/border-convex-bottom-right-water.png");
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = new Texture("tiles/border-right-water-1.png");
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = new Texture("tiles/border-left-water-1.png");
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = new Texture("tiles/border-convex-bottom-left-water-1.png");
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = new Texture("tiles/border-concave-right-bottom-water-1.png");
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = new Texture("tiles/border-bottom-water-1.png");
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = new Texture("tiles/border-top-left-water-intersection.png");
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = new Texture("tiles/border-concave-bottom-left-water-1.png");
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = new Texture("tiles/border-convex-top-left-water-1.png");
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = new Texture("tiles/border-top-water-1.png");
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = new Texture("tiles/border-convex-top-right-water-1.png");
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = new Texture("tiles/border-concave-bottom-left-water-intersection.png");
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = new Texture("tiles/border-concave-top-right.png");
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = new Texture("tiles/border-right.png");
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = new Texture("tiles/border-concave-bottom-right.png");
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = new Texture("tiles/border-bottom.png");
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = new Texture("tiles/border-concave-left-bottom.png");
            tile[26].collision = true;

            //House tiles
            for (int i = 27; i <= 46; i++) {
                tile[i] = new Tile();
                tile[i].image = new Texture("tiles/house/house-" + (i - 27) / 4 + "-" + (i - 27) % 4 + ".png");
                tile[i].collision = true;
            }

        } catch (Exception e) {
            throw new RuntimeException("Tile image not found "+e);
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = gamePanel.maxWorldRow - 1; // Start at the LAST row and go UP
            String line;

            while (row >= 0 && (line = br.readLine()) != null) {
                String[] numbers = line.split(" ");

                for (int col = 0; col < gamePanel.maxWorldCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num; // Flipped row index
                }

                row--; // Move UP instead of DOWN
            }

            br.close();

        } catch (Exception e) {
            throw new RuntimeException("Map Loading error: " + e);
        }
    }

    public void draw(SpriteBatch g2d){
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol< gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            //check if tiles is in the screen + 1 tile
            if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

                g2d.draw(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize);
            }

            worldCol++;

            if(worldCol == gamePanel.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
