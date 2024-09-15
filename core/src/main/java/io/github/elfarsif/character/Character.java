package io.github.elfarsif.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Character {

    public TextureListInitializer textureListInitializer;
    public TextureUpdater textureUpdater;

    public Character(){
        this.textureListInitializer = new TextureListInitializer();
        this.textureUpdater = new TextureUpdater(textureListInitializer);
    }

    public void input(){
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();
        boolean keyPressed = false;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.textureUpdater.currentTextures= this.textureListInitializer.texturesWalkingUp;
            this.textureUpdater.sprite.translateY(speed*delta);
            keyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalking;
            this.textureUpdater.sprite.translateY(-speed*delta);
            keyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.textureUpdater.sprite.translateX(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.textureUpdater.sprite.translateX(speed*delta);
        }
        if(!keyPressed){
            this.textureUpdater.currentTextures = this.textureListInitializer.texturesStanding;
        }
    }


    public TextureListInitializer getCharacterTextureRessourceManager() {
        return textureListInitializer;
    }

    public TextureUpdater getCharacterTextureUpdater() {
        return textureUpdater;
    }


}
