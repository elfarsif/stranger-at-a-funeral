package io.github.elfarsif.screens;

import io.github.elfarsif.Wall;
import io.github.elfarsif.character.Character;
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
import io.github.elfarsif.StrangerAtAFuneral;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    FitViewport viewport;
    private OrthographicCamera camera;
    private Sprite sprite;
    private OrthogonalTiledMapRenderer renderer;
    Character character;
    Wall wall;


    public GameScreen(StrangerAtAFuneral gameGdx) {
        character = new Character();
        wall = new Wall();
        wall.setPosition(3,0);
        loadMap();
        setScreenSettings(gameGdx);
    }

    private void loadMap() {
        TmxMapLoader loader = new TmxMapLoader();
        TiledMap tiledMap = loader.load("tilemaps/main_house_interior.tmx");
        float unitScale = 1f;
        renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
    }

    public void setScreenSettings(final StrangerAtAFuneral gameGdx){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 100, 300);
        this.gameGdx = gameGdx;
        viewport = new FitViewport(600, 300,camera);
    }

    @Override
    public void render(float delta) {
        input();
        ScreenUtils.clear(Color.RED);

        camera.position.set(100,100, 0);
        //handle collision logix
        //set map
        renderer.setView(camera);
        renderer.render();

        camera.update();

        viewport.apply();
        gameGdx.batch.setProjectionMatrix(viewport.getCamera().combined);

        gameGdx.batch.begin();
        gameGdx.batch.draw(new Texture(character.getCurrentTextureFileName()), character.getPosition()[0], character.getPosition()[1]);
        gameGdx.batch.end();
    }

    private void input() {
        character.verifyCollisionRight(wall);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            character.move("right");
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            character.move("left");
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
