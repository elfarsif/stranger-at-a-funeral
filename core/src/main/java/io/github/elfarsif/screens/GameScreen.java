package io.github.elfarsif.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.MapManager;
import io.github.elfarsif.StrangerAtAFuneral;
import io.github.elfarsif.character.Character;

public class GameScreen implements Screen {

    StrangerAtAFuneral game;
    Character character;
    FitViewport viewport;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private MapManager mapManager;


    public GameScreen(StrangerAtAFuneral game) {
        mapManager = new MapManager();
        setScreenSettings(game);
    }

    public void setScreenSettings(final StrangerAtAFuneral game){
        this.character = new Character(mapManager);
        float unitScale = 1f;
        renderer = new OrthogonalTiledMapRenderer(mapManager.map, unitScale);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 600, 300);

        this.game = game;
        viewport = new FitViewport(600, 300,camera);
    }

    @Override
    public void render(float delta) {
        input();
        this.character.getCharacterTextureUpdater().updateCharacterTexture(delta);
        ScreenUtils.clear(Color.BLACK);

        camera.position.set(this.character.getCharacterTextureUpdater().getSprite().getX(), this.character.getCharacterTextureUpdater().getSprite().getY(), 0);
        //handle collision logix

        camera.update();
        renderer.setView(camera);
        renderer.render();

        viewport.apply();
        game.batch.setProjectionMatrix(viewport.getCamera().combined);

        game.batch.begin();
        this.character.getCharacterTextureUpdater().getSprite().draw(game.batch);
        game.batch.end();
    }

    private void input() {
       this.character.input();
       renderer.setMap(this.mapManager.map);
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
        renderer.dispose();
    }

}
