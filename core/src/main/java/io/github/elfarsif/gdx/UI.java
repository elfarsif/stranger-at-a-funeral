package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    private GamePanel gp;
    private BitmapFont font;
    private Texture mushroomTexture;
    private boolean messageOn = false;
    private String message = "";
    private int messageCounter = 0;
    public boolean gameFinished = false;
    SpriteBatch spriteBatch;

    public UI(GamePanel gp) {
        this.gp = gp;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
    }

    public void showMessage(String message) {
        this.message = message;
        this.messageOn = true;
    }

    public void draw(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;

        font.setColor(Color.WHITE);
        if (gp.gameState == gp.playState) {
            // Play state stuff
        }

        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }

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
