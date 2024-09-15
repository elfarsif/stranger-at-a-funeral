package io.github.elfarsif.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Character {

    TextureListInitializer textureListInitializer;
    TextureUpdater textureUpdater;
    InputHandler inputHandler;

    public Character(){
        this.textureListInitializer = new TextureListInitializer();
        this.textureUpdater = new TextureUpdater(textureListInitializer);
        this.inputHandler = new InputHandler(textureUpdater, textureListInitializer);
    }

    public void input(){
        this.inputHandler.execute();
    }


    public TextureListInitializer getCharacterTextureRessourceManager() {
        return textureListInitializer;
    }

    public TextureUpdater getCharacterTextureUpdater() {
        return textureUpdater;
    }


}
