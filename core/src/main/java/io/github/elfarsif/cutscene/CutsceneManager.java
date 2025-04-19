package io.github.elfarsif.cutscene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.entity.PlayerCutsceneDummy;
import io.github.elfarsif.gdx.GamePanel;

public class CutsceneManager {

    GamePanel gp;
    SpriteBatch batch;
    public int sceneNum;
    public int scenePhase;
    int charIndex=0;


    //Scene Number
    public final int NA =0;
    public final int oscaelIntro =1;
    public final int gameStart =2;

    //Intro Cutscene Assets
    GameIntroCutscene gameIntroCutscene;


    public CutsceneManager(GamePanel gp){
        this.gp = gp;
        this.gameIntroCutscene = new GameIntroCutscene(gp);

    }

    public void draw(SpriteBatch g2d){
        this.batch = g2d;

        switch(sceneNum){
            case oscaelIntro:
                oscaelIntroCutscene();
                break;
            case gameStart:
                gameIntroCutscene.start(batch);
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


}
