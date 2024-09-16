package io.github.elfarsif.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler {
    TextureUpdater textureUpdater;
    TextureListInitializer textureListInitializer;
    boolean keyPressed;

    public InputHandler(TextureUpdater textureUpdater, TextureListInitializer textureListInitializer){
        this.textureUpdater = textureUpdater;
        this.textureListInitializer = textureListInitializer;
    }

    public void execute(){
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();
        keyPressed = false;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            moveUp(speed, delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            moveDown(speed, delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.textureUpdater.sprite.translateX(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight(speed, delta);
        }
        if(!keyPressed){
            this.textureUpdater.currentTextures = this.textureListInitializer.texturesStanding;
        }
    }

    private void moveUp(float speed, float delta) {
        this.textureUpdater.currentTextures= this.textureListInitializer.texturesWalkingUp;
        this.textureUpdater.sprite.translateY(speed * delta);
        keyPressed = true;
    }

    private void moveDown(float speed, float delta) {
        this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalking;
        this.textureUpdater.sprite.translateY(-speed * delta);
        keyPressed = true;
    }

    private void moveRight(float speed, float delta) {
        this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalkingRight;
        this.textureUpdater.sprite.translateX(speed * delta);
        keyPressed = true;
    }



}
