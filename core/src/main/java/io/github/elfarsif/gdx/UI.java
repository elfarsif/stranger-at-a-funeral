package io.github.elfarsif.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    private GamePanel gP;
    private BitmapFont font;
    private Texture mushroomTexture;
    private boolean messageOn = false;
    private String message = "";
    private int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gP) {
        this.gP = gP;
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.mushroomTexture = new Texture(Gdx.files.internal("objects/mushroom.png")); // Load your mushroom texture
    }

    public void showMessage(String message) {
        this.message = message;
        this.messageOn = true;
    }

    public void draw(SpriteBatch batch) {
        if (gameFinished) {
            String text = "Game Finished";
            GlyphLayout layout = new GlyphLayout(font, text);
            float x = (gP.screenWidth - layout.width) / 2;
            float y = gP.screenHeight / 2 - gP.tileSize * 2;
            font.setColor(Color.WHITE);
            font.draw(batch, text, x, y);
        } else {
            font.setColor(Color.WHITE);
            batch.draw(mushroomTexture, gP.tileSize / 2f, gP.tileSize / 2f, gP.tileSize, gP.tileSize);
            font.draw(batch, "x " + gP.player.hasMushroom, 80, 70);

            // MESSAGE
            if (messageOn) {
                font.getData().setScale(1.2f);
                font.draw(batch, message, 80, 150);
                messageCounter++;
                if (messageCounter > 100) {
                    messageOn = false;
                    messageCounter = 0;
                }
                font.getData().setScale(2f); // Reset font scale
            }
        }
    }
}
