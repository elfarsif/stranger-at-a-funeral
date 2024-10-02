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
import io.github.elfarsif.character.Character;
import io.github.elfarsif.model.Game;
import io.github.elfarsif.model.PlayableCharacter;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    Character character;
    FitViewport viewport;
    private OrthographicCamera camera;
    private MapManager mapManager;
    private Sprite sprite;
    private OrthogonalTiledMapRenderer renderer;
    Game game;


    public GameScreen(StrangerAtAFuneral gameGdx) {
        game = new Game();
        game.start();
        PlayableCharacter playableCharacter = new PlayableCharacter();
        game.getPlayer().setPlayableCharacter(playableCharacter);

        TmxMapLoader loader = new TmxMapLoader();
        TiledMap map = loader.load(game.getMap().getAssetFileName());

        float unitScale = 1f;
        renderer = new OrthogonalTiledMapRenderer(map, unitScale);

        setScreenSettings(gameGdx);
    }

    public void handleModel(){

    }


    public void setScreenSettings(final StrangerAtAFuneral gameGdx){
        sprite = new Sprite(new Texture(game.getPlayer().getPlayableCharacter().getCurrentAssetFileName()));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 600, 300);

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
        sprite.setTexture(new Texture(game.getPlayer().getPlayableCharacter().getCurrentAssetFileName()));
        game.getPlayer().getPlayableCharacter().updateTexture(delta);
        gameGdx.batch.end();
    }

    private void input() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            game.moveUp(sprite);
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
