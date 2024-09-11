package io.github.elfarsif;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.character.Character;
import io.github.elfarsif.character.CharacterAdapter;

public class Main implements ApplicationListener {
    SpriteBatch spriteBatch;
    FitViewport viewport;
    Character character;
    CharacterAdapter characterAdapter;

    @Override
    public void create() {

        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);
        character = new Character();
        characterAdapter = new CharacterAdapter(character);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            characterAdapter.getSprite().translateY(-speed * delta);
            character.moveDown();
        }
    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.RED);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        characterAdapter.getSprite().draw(spriteBatch);

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

    }
}
