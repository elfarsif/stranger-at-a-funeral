package io.github.elfarsif.gdx;

import io.github.elfarsif.entity.Oscael;
import io.github.elfarsif.monster.GreenSlime;
import io.github.elfarsif.objects.PineTree;
import io.github.elfarsif.objects.Sword;
import io.github.elfarsif.objects.SwordCopper;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.objects[0] = new PineTree(gp);
        gp.objects[0].collision = true;
        gp.objects[0].worldX = 10 * gp.tileSize;
        gp.objects[0].worldY = 6 * gp.tileSize;

        gp.objects[2] = new SwordCopper(gp);
        gp.objects[2].worldX = 30 * gp.tileSize;
        gp.objects[2].worldY = 12 * gp.tileSize;

    }

    public void setNPC(){
        gp.npc[0] = new Oscael(gp);
        gp.npc[0].worldX = 10 * gp.tileSize;
        gp.npc[0].worldY = 4 * gp.tileSize;
    }

    public void setMonster(){
        gp.monsters[0] = new GreenSlime(gp);
        gp.monsters[0].worldX = 30 * gp.tileSize;
        gp.monsters[0].worldY = 20 * gp.tileSize;

        gp.monsters[1] = new GreenSlime(gp);
        gp.monsters[1].worldX = 32 * gp.tileSize;
        gp.monsters[1].worldY = 22 * gp.tileSize;
    }
}
