package io.github.elfarsif.gdx;

import io.github.elfarsif.entity.Oscael;
import io.github.elfarsif.entity.StoreClerk;
import io.github.elfarsif.monster.GreenSlime;
import io.github.elfarsif.objects.*;
import io.github.elfarsif.tile_interactive.HoeableGrass;
import io.github.elfarsif.tile_interactive.PineTree;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        int mapNum =0;
        gp.objects[mapNum][0] = new SwordCopper(gp);
        gp.objects[mapNum][0].worldX = 30 * gp.tileSize;
        gp.objects[mapNum][0].worldY = 12 * gp.tileSize;

        gp.objects[mapNum][1] = new SwordCopper(gp);
        gp.objects[mapNum][1].worldX = 35 * gp.tileSize;
        gp.objects[mapNum][1].worldY = 12 * gp.tileSize;

        gp.objects[mapNum][3] = new Axe(gp);
        gp.objects[mapNum][3].worldX = 33 * gp.tileSize;
        gp.objects[mapNum][3].worldY = 12 * gp.tileSize;

        gp.objects[mapNum][4] = new Mushroom(gp);
        gp.objects[mapNum][4].worldX = 32 * gp.tileSize;
        gp.objects[mapNum][4].worldY = 14 * gp.tileSize;

        gp.objects[mapNum][7] = new WateringCan(gp);
        gp.objects[mapNum][7].worldX = 36 * gp.tileSize;
        gp.objects[mapNum][7].worldY =  12 * gp.tileSize;

        gp.objects[mapNum][8] = new Hoe(gp);
        gp.objects[mapNum][8].worldX = 36 * gp.tileSize;
        gp.objects[mapNum][8].worldY =  14 * gp.tileSize;

        gp.objects[mapNum][9] = new CarrotSeed(gp);
        gp.objects[mapNum][9].worldX = 38 * gp.tileSize;
        gp.objects[mapNum][9].worldY =  41 * gp.tileSize;


    }

    public void setNPC(){
        int mapNum =0;
        gp.npc[mapNum][0] = new Oscael(gp);
        gp.npc[mapNum][0].worldX = 39 * gp.tileSize;
        gp.npc[mapNum][0].worldY = 33* gp.tileSize;

        mapNum = 1;
        gp.npc[mapNum][0] = new StoreClerk(gp);
        gp.npc[mapNum][0].worldX = 36 * gp.tileSize;
        gp.npc[mapNum][0].worldY = 40* gp.tileSize;
    }

    public void setMonster(){
        int mapNum =0;
        gp.monsters[mapNum][0] = new GreenSlime(gp);
        gp.monsters[mapNum][0].worldX = 30 * gp.tileSize;
        gp.monsters[mapNum][0].worldY = 20 * gp.tileSize;

        gp.monsters[mapNum][1] = new GreenSlime(gp);
        gp.monsters[mapNum][1].worldX = 32 * gp.tileSize;
        gp.monsters[mapNum][1].worldY = 22 * gp.tileSize;
    }

    public void setInteractiveTiles() {
        int mapNum =0;

        gp.iTiles[mapNum][0] = new PineTree(gp);
        gp.iTiles[mapNum][0].collision = true;
        gp.iTiles[mapNum][0].worldX = 10 * gp.tileSize;
        gp.iTiles[mapNum][0].worldY = 6 * gp.tileSize;

        gp.iTiles[mapNum][0] = new PineTree(gp);
        gp.iTiles[mapNum][0].collision = true;
        gp.iTiles[mapNum][0].worldX = 40 * gp.tileSize;
        gp.iTiles[mapNum][0].worldY = 38 * gp.tileSize;

        gp.iTiles[mapNum][3] = new HoeableGrass(gp);
        gp.iTiles[mapNum][3].worldX = 44 * gp.tileSize;
        gp.iTiles[mapNum][3].worldY = 36 * gp.tileSize;

        gp.iTiles[mapNum][4] = new HoeableGrass(gp);
        gp.iTiles[mapNum][4].worldX = 45 * gp.tileSize;
        gp.iTiles[mapNum][4].worldY = 36 * gp.tileSize;
    }
}
