package io.github.elfarsif;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
import io.github.elfarsif.character.Character;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    final StrangerAtAFuneral game;
    Character character;
    FitViewport viewport;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;


    public GameScreen(final StrangerAtAFuneral game) {
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("grass.tmx");
        float unitScale = 1 / 200f;
        renderer = new OrthogonalTiledMapRenderer(map, unitScale);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 8, 5);



        this.game = game;
        this.character = new Character();
        viewport = new FitViewport(8, 5,camera);
    }

    @Override
    public void render(float delta) {
        input();
        this.character.getCharacterTextureUpdater().updateCharacterTexture(delta);
        ScreenUtils.clear(Color.BLUE);

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
        map.dispose();
        renderer.dispose();
    }

}
