package io.github.elfarsif.gdx;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GamePanel implements ApplicationListener {
    // SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 4;
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    private SpriteBatch spriteBatch;
    private Texture playerTexture;
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 3;

    //SYSTEM
    KeyHandler keyHandler = new KeyHandler();

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        playerTexture = new Texture("bucket.png");
        Gdx.input.setInputProcessor(keyHandler);
    }

    @Override
    public void resize(int i, int i1) {

    }

    private void update() {
        if (keyHandler.upPressed) {
            playerY += playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
        if (Gdx.input.isTouched()) { // If the user has clicked or tapped the screen
            System.out.println("Touched at: " + Gdx.input.getX() + ", " + Gdx.input.getY());
        }
    }

    @Override
    public void render() {
        update();
        draw();
    }

    private void draw() {
        ScreenUtils.clear(Color.BROWN);

        spriteBatch.begin();
        spriteBatch.draw(playerTexture, playerX, playerY, tileSize, tileSize);
        spriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        playerTexture.dispose();
    }
}
