package io.github.elfarsif.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.elfarsif.entity.Entity;
import io.github.elfarsif.entity.Player;

import io.github.elfarsif.tile.TileManager;
import io.github.elfarsif.tile_interactive.InteractiveTile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel implements ApplicationListener {
    // SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 3;
    public int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 30;
    private final int maxScreenRow = 16;

    //Screen size is in the laucher class manually change for now to match these
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public SpriteBatch spriteBatch;
    private Texture playerTexture;

    //WORLD SETTINGS
    public final int maxWorldCol = 64;
    public final int maxWorldRow = 48;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //SYSTEM
    public KeyHandler keyHandler;
    public TileManager tileManager;
    public CollisionChecker collisionChecker;
    public SoundWrapper music;
    public SoundWrapper soundEffect;
    public UI ui;
    public AssetSetter assetSetter = new AssetSetter(this);
    private BitmapFont font;
    public EventHandler eventHandler = new EventHandler(this);
    public boolean fullScreenOn = false;
    Config config;

    //ENTITIES AND OBJECTS
    public Player player;
    public Entity[] objects = new Entity[10];
    public Entity[] npc = new Entity[10];
    public Entity[] monsters = new Entity[10];
    ArrayList<Entity> entities = new ArrayList<Entity>();
    public ArrayList<Entity> projectiles = new ArrayList<Entity>();
    public InteractiveTile[] iTiles = new InteractiveTile[10];

    //GAME STATE
    public int gameState;
    public final int playState =1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int titleState = 4;
    public final int optionsState = 5;


    private static final int FPS = 60;
    private float deltaAccumulator = 0f;
    private float updateInterval = 1f / FPS;


    @Override
    public void create() {
        config = new Config(this);
        spriteBatch = new SpriteBatch();
        playerTexture = new Texture("bucket.png");
        keyHandler = new KeyHandler(this);
        Gdx.input.setInputProcessor(keyHandler);
        player = new Player(this, keyHandler);
        tileManager = new TileManager(this);
        collisionChecker = new CollisionChecker(this);
        music = new SoundWrapper();
        soundEffect = new SoundWrapper();
        ui = new UI(this);


        config.loadConfig();
        //FONT DEBUG
        this.font = new BitmapFont();
        this.font.getData().setScale(2f);
        this.font.setColor(Color.WHITE);

        //this will just resize window which streches the game
//        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
        setupGame();

    }

    public void setupGame(){
        gameState = playState;
        assetSetter.setObject();
        assetSetter.setNPC();
        assetSetter.setMonster();
        assetSetter.setInteractiveTiles();
        playMusic(0);

        if(fullScreenOn){
//            setFullScreen();
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    public void update() {
        if(gameState == playState){
            player.update();
            //update all npc
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            //update monsters
            for(int i = 0; i < monsters.length; i++){
                if(monsters[i] != null){
                    if (monsters[i].alive && !monsters[i].dying){
                        monsters[i].update();
                    }
                    if (!monsters[i].alive){
                        monsters[i].checkDrop();
                        monsters[i] = null;
                    }
                }
            }
            //update projectiles
            for(int i = 0; i < projectiles.size(); i++){
                if(projectiles.get(i) != null){
                    if (projectiles.get(i).alive){
                        projectiles.get(i).update();
                    }
                    if (!projectiles.get(i).alive){
                        projectiles.remove(i);
                    }
                }
            }
            //update interactive tiles
            for (int i = 0; i < iTiles.length; i++){
                if(iTiles[i] != null){
                    iTiles[i].update();
                }
            }
        }
        if(gameState == pauseState){
            //TODO
        }
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        deltaAccumulator += deltaTime;

        while (deltaAccumulator >= updateInterval) {

            spriteBatch.begin();
            update();
            draw();
            spriteBatch.end();
            deltaAccumulator -= updateInterval;
        }


    }

    private void draw() {

        ScreenUtils.clear(Color.BLACK);

        //DEBUG
        long drawStart = 0;
        if(keyHandler.showDebug){
            drawStart = System.nanoTime();
        }

        if (gameState == titleState){
            ui.draw(spriteBatch);
        }else{
            //DRAW TILES
            tileManager.draw(spriteBatch);

            for (int i = 0 ; i < iTiles.length; i++){
                if(iTiles[i] != null){
                    iTiles[i].draw(spriteBatch);
                }
            }

            //ADD ENTITIES TO LIST
            entities.add(player);
            //ADD INTERACTIVE TILES
            for (int i = 0; i < iTiles.length; i++){
                if(iTiles[i] != null){
                    entities.add(iTiles[i]);
                }
            }

            //NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    entities.add(npc[i]);
                }
            }

            //OBJECTS
            for(int i = 0; i < objects.length; i++){
                if(objects[i] != null){
                    entities.add(objects[i]);
                }
            }

            //MONSTERS
            for(int i = 0; i < monsters.length; i++){
                if(monsters[i] != null){
                    entities.add(monsters[i]);
                }
            }

            //paint projectiles
            for(int i = 0; i < projectiles.size(); i++){
                if(projectiles.get(i) != null){
                    entities.add(projectiles.get(i));
                }
            }

            //SORT by world Y so lower entities are drawn first so that higher entities dont overlap on top
            Collections.sort(entities, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e2.worldY, e1.worldY);
                    return result;
                }
            });


            //DRAW ENTITIES
            for(Entity e : entities){
                e.draw(spriteBatch);
            }

            //EMPTY LIST
            entities.clear();

            //DRAW UI
            ui.draw(spriteBatch);
        }

        //DEBUG
        if(keyHandler.showDebug){
            long drawEnd = System.nanoTime();
            long drawTime = drawEnd - drawStart;
            int x = 10;
            int y = 400;
            int lineHeight = 20;
            font.draw(spriteBatch, "Player X: " + player.worldX, x, y);
            y += lineHeight;
            font.draw(spriteBatch, "Player Y: " + player.worldY, x, y);
            y += lineHeight;
            font.draw(spriteBatch, "Player Col: " + (player.worldX+player.solidArea.x)/tileSize, x, y);
            y += lineHeight;
            font.draw(spriteBatch, "Player Row: " + (player.worldY+player.solidArea.y)/tileSize, x, y);
            y += lineHeight;
            font.draw(spriteBatch, "Draw Time: " + drawTime, 10, 30);
        }

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
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }
    public void playSoundEffect(int i){
        soundEffect.setFile(i);
        soundEffect.play();
    }
}
