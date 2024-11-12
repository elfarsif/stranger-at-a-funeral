package io.github.elfarsif.screens;

import com.badlogic.gdx.maps.tiled.TiledMap;
import io.github.elfarsif.Map;
import io.github.elfarsif.Wall;
import io.github.elfarsif.character.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.elfarsif.StrangerAtAFuneral;

public class GameScreen implements Screen {

    StrangerAtAFuneral gameGdx;
    FitViewport viewport;
    Texture[][] textures;
    Character character;
    Wall wall;
    Map map;

    public GameScreen(StrangerAtAFuneral gameGdx) {
        map = new Map();
        character = new Character(map);
        wall = new Wall();
        wall.setPosition(3,0);
        this.gameGdx = gameGdx;
        loadMap();
    }

    private void loadMap() {
        textures = new Texture[map.getSize()[0]][map.getSize()[1]];

        for(int x = 0; x < map.getSize()[0]; x++){
            for(int y = 0; y < map.getSize()[1]; y++){
                textures[x][y] = new Texture(map.getTile(x,y).getFileLocation());
            }
        }
    }

    @Override
    public void render(float delta) {
        input();
        ScreenUtils.clear(Color.RED);

        gameGdx.batch.begin();
        for (int x = 0; x < map.getSize()[0]; x++) {
            for (int y = 0; y < map.getSize()[1]; y++) {
                gameGdx.batch.draw(textures[x][y], x * 16, y * 16);
            }
        }
        gameGdx.batch.draw(new Texture(character.getCurrentTextureFileName()), character.getPosition()[0]+19*16, character.getPosition()[1]);
        gameGdx.batch.end();
    }

    private void input() {
        character.verifyCollisionRight(wall);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            character.move("right");
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            character.move("left");
        }else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            character.move("up");
        }else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            character.move("down");
        }

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
