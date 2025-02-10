package io.github.elfarsif.gdx;

import io.github.elfarsif.objects.Door;
import io.github.elfarsif.objects.Mushroom;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void setObject(){
        gamePanel.objects[0] = new Mushroom();
        gamePanel.objects[0].worldX = 2 * gamePanel.tileSize;
        gamePanel.objects[0].worldY = 4 * gamePanel.tileSize;

        gamePanel.objects[1] = new Mushroom();
        gamePanel.objects[1].worldX = 6 * gamePanel.tileSize;
        gamePanel.objects[1].worldY = 4 * gamePanel.tileSize;

        gamePanel.objects[2] = new Door();
        gamePanel.objects[2].worldX = 4 * gamePanel.tileSize;
        gamePanel.objects[2].worldY = 4 * gamePanel.tileSize;
    }
}
