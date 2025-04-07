package io.github.elfarsif.tile_interactive;

import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.gdx.GamePanel;

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
        makeDestructible();
    }



    public boolean isCorrectTool(Entity entity){
        boolean correctTool = false;
        if(entity.currentWeapon.type== type_axe){
            correctTool = true;
        }
        return correctTool;
    }



}
