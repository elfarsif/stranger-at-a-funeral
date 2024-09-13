package io.github.elfarsif;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.character.Character;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    final StrangerAtAFuneral game;
    Character character;
    FitViewport viewport;


    public GameScreen(final StrangerAtAFuneral game) {
        this.game = game;
        this.character = new Character();
        viewport = new FitViewport(8, 5);
    }

    @Override
    public void render(float delta) {
        input();
        this.character.updateCharacterTexture(delta);
        ScreenUtils.clear(Color.BLUE);

        viewport.apply();
        game.batch.setProjectionMatrix(viewport.getCamera().combined);

        game.batch.begin();
        this.character.getSprite().draw(game.batch);
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
    }

}
