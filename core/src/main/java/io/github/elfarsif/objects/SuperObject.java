package io.github.elfarsif.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

import java.awt.*;

public class SuperObject {

    Sprite image;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;

    public SuperObject(){
        setDefaultSolidArea();
    }
    private void setDefaultSolidArea() {
        solidArea = new Rectangle();
        solidArea.x = 12*3;
        solidArea.y = 24*3;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 8*3;
        solidArea.height = 8*3;
    }


    public void draw(SpriteBatch g2d, GamePanel gamePanel){
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        //check if tiles is in the screen + 1 tile
        if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
            worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
            worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
            worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY){

            g2d.draw(image, screenX, screenY, image.getWidth(), image.getHeight());
        }

    }
}
