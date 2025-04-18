package io.github.elfarsif.gdx;

import com.badlogic.gdx.graphics.Pixmap;
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
    public Sprite blackBackground;
    public Sprite firstCutsceneImage;

    public CutsceneManager(GamePanel gp){
        this.gp = gp;
        generateBlackBackgroundSprite();
        loadCutsceneAssets();
    }

    private void loadCutsceneAssets() {
        try {
            firstCutsceneImage = new Sprite(new Texture("cutscene/intro-cutscene-1.png"));
            firstCutsceneImage.setSize(gp.screenWidth/2, gp.screenHeight/2);
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

    private void generateBlackBackgroundSprite(){
        // Create a 1x1 black pixel texture
        Texture blackTexture;
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 1);
        pixmap.fill();
        blackTexture = new Texture(pixmap);
        pixmap.dispose(); // No longer needed after texture creation

        blackBackground = new Sprite(blackTexture);
        blackBackground.setSize(gp.screenWidth, gp.screenHeight);


    }


    public void gameStartCutscene(){
        batch.draw(blackBackground, 0, 0,blackBackground.getWidth(), blackBackground.getHeight());
        addFirstCutsceneImage();

    }

    private void addFirstCutsceneImage() {
        int imageXposition = (int) (gp.screenWidth/2-(firstCutsceneImage.getWidth()/2));
        int imageYposition = (int) (gp.screenHeight-(firstCutsceneImage.getHeight()+gp.tileSize));
        batch.draw(firstCutsceneImage, imageXposition, imageYposition, firstCutsceneImage.getWidth(), firstCutsceneImage.getHeight());
    }

}
