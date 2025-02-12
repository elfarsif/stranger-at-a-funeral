package io.github.elfarsif.gdx;

import io.github.elfarsif.entity.Oscael;
import io.github.elfarsif.objects.Door;
import io.github.elfarsif.objects.Mushroom;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.objects[0] = new Mushroom();
        gp.objects[0].worldX = 2 * gp.tileSize;
        gp.objects[0].worldY = 4 * gp.tileSize;

        gp.objects[1] = new Mushroom();
        gp.objects[1].worldX = 6 * gp.tileSize;
        gp.objects[1].worldY = 4 * gp.tileSize;

        gp.objects[2] = new Door();
        gp.objects[2].worldX = 4 * gp.tileSize;
        gp.objects[2].worldY = 4 * gp.tileSize;
    }

    public void setNPC(){
        gp.npc[0] = new Oscael(gp);
        gp.npc[0].worldX = 10 * gp.tileSize;
        gp.npc[0].worldY = 4 * gp.tileSize;
    }
}
