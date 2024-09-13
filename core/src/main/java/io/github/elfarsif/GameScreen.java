package io.github.elfarsif;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    final StrangerAtAFuneral game;
    Texture character;
    Sprite characterSprite;
    FitViewport viewport;
    List<Texture> textures = new ArrayList<Texture>();
    int currentTexture = 0;
    float animationTime = 0;
    float animationInterval = 0.3f;


    public GameScreen(final StrangerAtAFuneral game) {
        this.game = game;

        Ressource Ressource = new Ressource();
        textures.add(Ressource.getMainDownStanding1());
        textures.add(Ressource.getMainDownStanding2());
        textures.add(Ressource.getMainDownStanding3());
        textures.add(Ressource.getMainDownStanding4());
        textures.add(Ressource.getMainDownStanding5());

        this.character = Ressource.getMainDownStanding1();

        viewport = new FitViewport(8, 5);
        this.characterSprite = new Sprite(character);
        this.characterSprite.setSize(0.5f,0.5f);

    }

    @Override
    public void render(float delta) {
        input();
        updateCharacterTexture(delta);
        ScreenUtils.clear(Color.BLUE);

        viewport.apply();
        game.batch.setProjectionMatrix(viewport.getCamera().combined);

        game.batch.begin();
        this.characterSprite.draw(game.batch);
        game.batch.end();
    }

    private void updateCharacterTexture(float delta) {
        animationTime += delta;
        if (animationTime > animationInterval) {
            currentTexture++;
            if (currentTexture >= textures.size()) {
                currentTexture = 0;
            }
            this.character = textures.get(currentTexture);
            this.characterSprite.setTexture(character);
            animationTime = 0;
        }
    }

    private void input() {
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            this.characterSprite.translateY(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            this.characterSprite.translateY(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            this.characterSprite.translateX(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            this.characterSprite.translateX(speed*delta);
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
