package io.github.elfarsif.tile_interactive;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

import java.awt.*;

public class PineTreeTrunk extends InteractiveTile{
    GamePanel gp;

    public PineTreeTrunk(GamePanel gp, int worldX, int worldY) {
        super(gp);
        this.gp = gp;
        down1 = setup("objects/pine-tree-trunk.png");
        down2 = setup("objects/pine-tree-trunk.png");
        this.worldX = worldX*gp.tileSize;
        this.worldY = worldY*gp.tileSize;
        currentLife = 3;
        setupSolidArea();
        makeDestructible();
    }

    private void setupSolidArea() {
        solidArea = new Rectangle();
        solidArea.x = 12 * gp.scale;
        solidArea.y = 0 * gp.scale;
        solidArea.width = 8 * gp.scale;
        solidArea.height = 8 * gp.scale;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    @Override
    public Sprite setup(String path){
        Sprite image = null;
        try {
            image = new Sprite(new Texture(path));
            image.setSize(gp.tileSize*2, gp.tileSize*2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image :"+e);
        }
        return image;
    }



    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        if(entity.currentWeapon.type== type_axe){
            correctTool = true;
        }
        return correctTool;
    }



}
