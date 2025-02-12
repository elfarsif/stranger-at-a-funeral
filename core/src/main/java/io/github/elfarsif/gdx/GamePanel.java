package io.github.elfarsif.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.elfarsif.entity.Player;

import io.github.elfarsif.objects.SuperObject;
import io.github.elfarsif.tile.TileManager;

public class GamePanel implements ApplicationListener {
    // SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 3;
    public int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 20;
    private final int maxScreenRow = 10;
    //Screen size is in the laucher class manually change for now to match these
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    private SpriteBatch spriteBatch;
    private Texture playerTexture;

    //WORLD SETTINGS
    public final int maxWorldCol = 64;
    public final int maxWorldRow = 48;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //SYSTEM
    KeyHandler keyHandler;
    public Player player;
    public TileManager tileManager;
    public CollisionChecker collisionChecker;
    public SoundWrapper soundWrapper;
    public UI ui;
    public SuperObject objects[] = new SuperObject[10];
    public AssetSetter assetSetter = new AssetSetter(this);


    private static final int FPS = 60;
    private float deltaAccumulator = 0f;
    private float updateInterval = 1f / FPS;


    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        playerTexture = new Texture("bucket.png");
        keyHandler = new KeyHandler();
        Gdx.input.setInputProcessor(keyHandler);
        player = new Player(this, keyHandler);
        tileManager = new TileManager(this);
        collisionChecker = new CollisionChecker(this);
        soundWrapper = new SoundWrapper();
        ui = new UI(this);

        //this will just resize window which streches the game
//        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
        setupGame();

    }

    public void setupGame(){
        assetSetter.setObject();
        playMusic(0);
    }

    @Override
    public void resize(int i, int i1) {

    }

    public void update() {
        player.update();
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        deltaAccumulator += deltaTime;

        while (deltaAccumulator >= updateInterval) {
            update();
            deltaAccumulator -= updateInterval;
        }

        draw();
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();

        //DRAW TILES
        tileManager.draw(spriteBatch);

        //DRAW OBJECTS
        for(int i = 0; i < objects.length; i++){
            if(objects[i] != null){
                objects[i].draw(spriteBatch, this);
            }
        }

        //DRAW PLAYER
        player.draw(spriteBatch);

        //DRAW UI
        ui.draw(spriteBatch);

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

    public void playMusic(int i){
        soundWrapper.setFile(i);
        soundWrapper.play();
        soundWrapper.loop();
    }

    public void stopMusic(){
        soundWrapper.stop();
    }
    public void playSoundEffect(int i){
        soundWrapper.setFile(i);
        soundWrapper.play();
    }
}
