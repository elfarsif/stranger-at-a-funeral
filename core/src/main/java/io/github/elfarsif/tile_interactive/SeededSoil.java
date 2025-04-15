package io.github.elfarsif.tile_interactive;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

import java.awt.*;

public class SeededSoil extends InteractiveTile{
    GamePanel gp;
    public SeededSoil(GamePanel gp, int worldX, int worldY) {
        super(gp);
        this.gp = gp;
        down1 = setup("tiles/farming/carrot-seeded-soil.png");
        down2 = setup("tiles/farming/carrot-seeded-soil.png");
        this.worldX = worldX*gp.tileSize;
        this.worldY = worldY*gp.tileSize;
        currentLife = 1;
        walkOverable = true;
        destructible = false;
    }

    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        if(entity.currentWeapon.type== type_seed){
            System.out.println("Correct tool");
            correctTool = true;
        }
        return correctTool;
    }

    public InteractiveTile getDestroyedTile(){

        return null;
    }
    @Override
    public Sprite setup(String filePath) {
        Sprite image = null;
        try {
            image = new Sprite(new Texture(filePath));
            image.setSize(gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :" + e);
        }
        return image;
    }
}
