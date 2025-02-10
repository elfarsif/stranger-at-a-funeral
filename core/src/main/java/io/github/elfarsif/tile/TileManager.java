package io.github.elfarsif.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

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

        tile = new Tile[10];
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
