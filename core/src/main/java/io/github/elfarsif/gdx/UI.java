package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
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
    private Texture titleScreenImage;
    public int commandNum = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.shapeRenderer = new ShapeRenderer();
        loadBackgroundImage();
    }

    private void loadBackgroundImage() {
        try{
            titleScreenImage = new Texture(Gdx.files.internal("player/standing/character.png"));
        }catch (Exception e){
            throw new RuntimeException("Error loading image Door:"+e);
        }
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
        String text = "Spiritstead";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight - gp.tileSize*2;

        //SHADOW
        font.setColor(Color.GRAY);
        font.draw(spriteBatch, text, x + 3, y - 3);
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, text, x, y);

        //Image
        x = gp.screenWidth / 2 - gp.tileSize;
        y -= gp.tileSize*3;
        spriteBatch.draw(titleScreenImage, x, y, gp.tileSize*2, gp.tileSize*2);

        //MENU
        font.getData().setScale(1.5f);
        text = "New Game";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 0){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }

        text = "Load Game";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 1){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }

        text = "Quit";
        x = getXforCenteredText(text);
        y -= gp.tileSize;
        font.draw(spriteBatch, text, x, y);
        if(commandNum == 2){
            font.draw(spriteBatch, ">", x - gp.tileSize, y);
        }
    }

    private void drawDialogScreen() {
        //Window
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - gp.tileSize*4;
        int height = gp.tileSize*5;

        drawSubWindow(x,y,width,height);
        font = new BitmapFont();
        font.getData().setScale(1.5f); // Adjust font size as needed
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, currentDialog, x + gp.tileSize, y + height - gp.tileSize);
    }

    public void drawSubWindow(int x, int y, int width, int height){
        Texture rectangleTexture;
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        // Draw filled rectangle (semi-transparent black)
        pixmap.setColor(new Color(0, 0, 0, 0.8f));
        pixmap.fillRectangle(0, 0, width, height);

        // Draw border (white)
        pixmap.setColor(Color.WHITE);
        pixmap.drawRectangle(3, 3, width - 6, height - 6);

        // Convert Pixmap to Texture
        rectangleTexture = new Texture(pixmap);
        pixmap.dispose();
        gp.spriteBatch.draw(rectangleTexture, x, y);
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
