package io.github.elfarsif.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.MapManager;
import io.github.elfarsif.StrangerAtAFuneral;
import io.github.elfarsif.model.*;
import io.github.elfarsif.model.Character;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    FitViewport viewport;
    private OrthographicCamera camera;
    private MapManager mapManager;
    private Sprite sprite;
    private OrthogonalTiledMapRenderer renderer;
    Game game;
    Character character;



    public GameScreen(StrangerAtAFuneral gameGdx) {
        Map map = new HouseMap();
        character = new Character();
        game = new Game(map,character);

        TmxMapLoader loader = new TmxMapLoader();
        TiledMap tiledMap = loader.load(game.getMap().getAssetFileName());

        float unitScale = 1f;
        renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

        setScreenSettings(gameGdx);
        setInitialPlayerPosition();
    }

    private void setInitialPlayerPosition() {
        game.setCharacterInHouse();
        sprite.setPosition(game.getCharacter().getX(),
            game.getCharacter().getY());
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
        sprite.setTexture(new Texture(game.getCharacter().getCurrentAssetFileName()));
        game.getCharacter().updateTexture(delta);
        gameGdx.batch.end();
    }

    private void input() {
        this.game.isMoving = false;

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            game.move(character,"up");
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            game.moveDown(sprite);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            game.moveLeft(sprite);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            game.moveRight(sprite);
        }
        game.stopMoving();
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
