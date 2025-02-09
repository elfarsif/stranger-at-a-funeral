package io.github.elfarsif.gdx;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.elfarsif.entity.Player;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GamePanel implements ApplicationListener {
    // SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 4;
    public int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    private SpriteBatch spriteBatch;
    private Texture playerTexture;

    //SYSTEM
    KeyHandler keyHandler;
    Player player;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        playerTexture = new Texture("bucket.png");
        keyHandler = new KeyHandler();
        Gdx.input.setInputProcessor(keyHandler);
        player = new Player(this, keyHandler);

        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);

    }

    @Override
    public void resize(int i, int i1) {

    }

    public void update() {
        player.update();
    }

    @Override
    public void render() {
        update();
        draw();
    }

    private void draw() {
        ScreenUtils.clear(Color.BROWN);

        spriteBatch.begin();
        player.draw(spriteBatch);
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
