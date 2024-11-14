package io.github.elfarsif.gdx;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    FitViewport viewport;
    Texture[][] textures;

    public GameScreen(StrangerAtAFuneral gameGdx) {
        this.gameGdx = gameGdx;
        loadMap();
    }

    private void loadMap() {

    }

    @Override
    public void render(float delta) {
        input();
        ScreenUtils.clear(Color.RED);

        gameGdx.batch.begin();

        gameGdx.batch.end();
    }

    private void input() {

    }

    @Override
    public void resize(int width, int height) {
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
