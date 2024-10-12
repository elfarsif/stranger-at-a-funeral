package io.github.elfarsif.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.MapManager;
import io.github.elfarsif.StrangerAtAFuneral;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    FitViewport viewport;
    private OrthographicCamera camera;
    private MapManager mapManager;
    private Sprite sprite;
    private OrthogonalTiledMapRenderer renderer;
    Game game;
    Character character;
    Map map;
    MovementHandler movementHandler;
    Wall wall;



    public GameScreen(StrangerAtAFuneral gameGdx) {
        map = new HouseMap();
        character = new Character();
        movementHandler = new MovementHandler(character);
        game = new Game(map,character,movementHandler);
        WallObjectInitializer wallObjectInitializer = new WallObjectInitializer();
        wall = new Wall(map, wallObjectInitializer);

        TmxMapLoader loader = new TmxMapLoader();
        TiledMap tiledMap = loader.load(map.getAssetFileName());

        float unitScale = 1f;
        renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

        setScreenSettings(gameGdx);
        setInitialPlayerPosition();
        wall.initilizeCollisionObjects();
    }

    private void setInitialPlayerPosition() {
        map.addCharacter(character);
        sprite.setPosition(character.getX(), character.getY());
    }

    public void setScreenSettings(final StrangerAtAFuneral gameGdx){
        sprite = new Sprite(new Texture(character.getCurrentAssetFileName()));
        character.setSprite(sprite);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 100, 300);

        this.gameGdx = gameGdx;
        viewport = new FitViewport(600, 300,camera);
    }

    @Override
    public void render(float delta) {
        input();
        ScreenUtils.clear(Color.BLACK);

        camera.position.set(100,100, 0);
        //handle collision logix
        //set map
        renderer.setView(camera);
        renderer.render();

        camera.update();

        viewport.apply();
        gameGdx.batch.setProjectionMatrix(viewport.getCamera().combined);

        gameGdx.batch.begin();
        sprite.draw(gameGdx.batch);
        sprite.setTexture(new Texture(character.getCurrentAssetFileName()));
        character.updateTexture(delta);
        gameGdx.batch.end();
    }

    private void input() {
        movementHandler.isMoving = false;

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            game.move(character,"up");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            game.move(character,"down");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            game.move(character,"left");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(!isColliding(character.getSprite())){
                game.move(character,"right");
            }
        }

        movementHandler.stopMoving();
    }


    private boolean isColliding(Sprite sprite){
        for(Rectangle rectangle: wall.getCollisionRectangles()){
            if(sprite.getBoundingRectangle().overlaps(rectangle)){
                return true;
            }
        }
        return false;
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
