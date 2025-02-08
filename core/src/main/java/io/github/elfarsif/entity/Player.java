package io.github.elfarsif.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;
import io.github.elfarsif.gdx.GamePanel;
import io.github.elfarsif.gdx.KeyHandler;

public class Player extends Entity {
    private Texture playerTexture;
    private KeyHandler keyHandler;
    GamePanel gp;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gp = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        playerTexture = new Texture("bucket.png");
    }

    public void update() {
        if (keyHandler.upPressed) {
            y += speed;
        }
        if (keyHandler.downPressed) {
            y -= speed;
        }
        if (keyHandler.leftPressed) {
            x -= speed;
        }
        if (keyHandler.rightPressed) {
            x += speed;
        }
        if (Gdx.input.isTouched()) { // If the user has clicked or tapped the screen
            System.out.println("Touched at: " + Gdx.input.getX() + ", " + Gdx.input.getY());
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(playerTexture, x, y, gp.tileSize, gp.tileSize);
    }

    /**
     * Disposes of the player texture when the game is closed. Not sure how to use yet
     */
    public void dispose() {
        playerTexture.dispose();
    }
}

