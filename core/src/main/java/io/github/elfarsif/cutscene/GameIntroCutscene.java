package io.github.elfarsif.cutscene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.elfarsif.gdx.GamePanel;

public class GameIntroCutscene {
    //System
    GamePanel gp;
    SpriteBatch batch;

    BitmapFont font;
    public Sprite blackBackground;
    public Sprite firstCutsceneImage;
    String displayedText = "";
    int charIndex=0;
    String combinedText = "";

    public GameIntroCutscene(GamePanel gp){
        this.gp = gp;
        generateBlackBackgroundSprite();
        loadCutsceneAssets();
    }

    public void start(SpriteBatch batch) {
        this.batch= batch;

        batch.draw(blackBackground, 0, 0,blackBackground.getWidth(), blackBackground.getHeight());

        //addFirstCutsceneImage
        int imageXposition = (int) (gp.screenWidth/2-(firstCutsceneImage.getWidth()/2));
        int imageYposition = (int) (gp.screenHeight-(firstCutsceneImage.getHeight()+gp.tileSize));
        batch.draw(firstCutsceneImage, imageXposition, imageYposition, firstCutsceneImage.getWidth(), firstCutsceneImage.getHeight());

        addFirstCutsceneText(imageYposition);

    }


    private void loadCutsceneAssets() {
        try {
            firstCutsceneImage = new Sprite(new Texture("cutscene/intro-cutscene-1.png"));
            firstCutsceneImage.setSize(gp.screenWidth/2, gp.screenHeight/2);
        } catch (Exception e) {
            throw new RuntimeException("Error reading image for mushroom:" + e);
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

    private void addFirstCutsceneText(int imageYposition) {
        font = new BitmapFont();
        font.getData().setScale(2f);
        font.setColor(Color.WHITE);
        String text = "Welcome to Oscael";


        //Letter by letter effect
        char characters[] = text.toCharArray();

        if (charIndex < characters.length) {
            String s = String.valueOf(characters[charIndex]);
            combinedText += s;
            displayedText = combinedText;
            charIndex++;
        }
        font.draw(batch, displayedText,gp.ui.getXforCenteredText(text) ,imageYposition-gp.tileSize);

    }


}
