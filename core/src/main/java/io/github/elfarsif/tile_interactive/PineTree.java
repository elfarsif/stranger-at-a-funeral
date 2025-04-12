package io.github.elfarsif.tile_interactive;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

import java.awt.*;

public class PineTree extends InteractiveTile {
    GamePanel gp;

    public PineTree(GamePanel gp) {
        super(gp);
        this.gp = gp;
        down1 = setup("objects/pine-tree.png");
        down2 = setup("objects/pine-tree.png");
        destructible = true;
        currentLife = 3;
        setupSolidArea();
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

    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        if(entity.currentWeapon.type== type_axe){
            correctTool = true;
        }
        return correctTool;
    }

    public InteractiveTile getDestroyedTile(){
        InteractiveTile tile = new PineTreeTrunk(gp, worldX/gp.tileSize, worldY/gp.tileSize);
        return tile;
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
}
