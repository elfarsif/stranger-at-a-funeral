package io.github.elfarsif.character;

import io.github.elfarsif.MapManager;

public class Character {

    TextureListInitializer textureListInitializer;
    TextureUpdater textureUpdater;
    InputHandler inputHandler;


    public Character(MapManager mapManager) {
        this.textureListInitializer = new TextureListInitializer();
        this.textureUpdater = new TextureUpdater(textureListInitializer);
        this.inputHandler = new InputHandler(textureUpdater, textureListInitializer, mapManager);
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


    public InputHandler getInputHandler() {
        return inputHandler;
    }

}
