package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class UI {
    private GamePanel gp;
    private BitmapFont font;
    private Texture mushroomTexture;
    private boolean messageOn = false;
    private String message = "";
    private int messageCounter = 0;
    public boolean gameFinished = false;
    SpriteBatch spriteBatch;
    public String currentDialog;
    private ShapeRenderer shapeRenderer;

    public UI(GamePanel gp) {
        this.gp = gp;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.shapeRenderer = shapeRenderer;
    }

    public void showMessage(String message) {
        this.message = message;
        this.messageOn = true;
    }

    public void draw(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;

        font.setColor(Color.WHITE);
        //Play State
        if (gp.gameState == gp.playState){
            //play state studd
        }

        //Pause State
        if (gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //Dialog State
        if (gp.gameState == gp.dialogueState){
            drawDialogScreen();
        }
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
    }

    private void drawTitleScreen() {
        font.getData().setScale(2f);
        String text = "Title Screen";
        GlyphLayout layout = new GlyphLayout(font, text);
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        font.draw(spriteBatch, text, x, y);
    }

    private void drawDialogScreen() {
        //Window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - gp.tileSize*4;
        int height = gp.tileSize*5;

        drawSubWindow(x,y,width,height);
        font.getData().setScale(1.5f); // Adjust font size as needed
        font.setColor(Color.WHITE);
        GlyphLayout layout = new GlyphLayout(font, currentDialog);
        font.draw(spriteBatch, currentDialog, x + gp.tileSize, y + height - gp.tileSize);
    }

    public void drawSubWindow(int x, int y, int width, int height){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0, 0, 0, 0.8f)); // Semi-transparent black
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(x + 3, y + 3, width - 6, height - 6);
        shapeRenderer.end();
    }

    private void drawPauseScreen() {
        String text = "PAUSED";

        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        font.draw(spriteBatch, text, x, y);
    }

    public int getXforCenteredText(String text){
        GlyphLayout layout = new GlyphLayout(font, text);
        return (int) (gp.screenWidth / 2 - layout.width / 2);
    }
}
