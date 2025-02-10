package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

public class SuperObject {

    Texture image;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;

    public void draw(SpriteBatch g2d, GamePanel gamePanel){
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        //check if tiles is in the screen + 1 tile
        if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
            worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
            worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
            worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

            g2d.draw(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize);
        }

    }
}
