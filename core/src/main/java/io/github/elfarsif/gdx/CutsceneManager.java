package io.github.elfarsif.gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.entity.PlayerCutsceneDummy;

public class CutsceneManager {

    GamePanel gp;
    SpriteBatch batch;
    public int sceneNum;
    public int scenePhase;

    //Scene Number
    public final int NA =0;
    public final int oscaelIntro =1;
    public final int gameStart =2;

    //Intro Cutscene Assets
    public Sprite image;

    public CutsceneManager(GamePanel gp){
        this.gp = gp;
        loadGameStartCutsceneAssets();
    }

    private void loadGameStartCutsceneAssets() {
        try {
            image = new Sprite(new Texture("ui/stardewValley.png"));
            image.setSize(gp.screenWidth, gp.screenHeight);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image for mushroom:" + e);
        }
    }

    public void draw(SpriteBatch g2d){
        this.batch = g2d;

        switch(sceneNum){
            case oscaelIntro:
                oscaelIntroCutscene();
                break;
            case gameStart:
                gameStartCutscene();
                break;
        }
    }

    public void oscaelIntroCutscene(){
        if(scenePhase == 0){
            //allows to move camera effect so you move player without seeing player
            gp.player.drawing = false;
            //add dummy player in vacant slot
            for(int i = 0; i < gp.npc[gp.currentMap].length; i++){
                if(gp.npc[gp.currentMap][i] == null){
                    gp.npc[gp.currentMap][i] = new PlayerCutsceneDummy(gp);
                    gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
                    gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
                    gp.npc[gp.currentMap][i].direction = gp.player.direction;
                    break;
                }
            }
            scenePhase++;
        }
        if (scenePhase == 1){
            //move camera down
            gp.player.worldY+=2;
            //stop camera at certain point
            if(gp.player.worldY >= 20 * gp.tileSize){
                scenePhase++;
            }
        }
        if (scenePhase == 2){
            // move to slime monster
        }


    }


    public void gameStartCutscene(){
        batch.draw(image, 0, 0,image.getWidth(), image.getHeight());

    }

}
