package io.github.elfarsif.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.List;

public class TextureUpdater {
    Texture currentTexture;
    List<Texture> currentTextures;
    int currentTextureIndex = 0;
    float animationTime = 0;
    float animationInterval = 0.15f;
    Sprite sprite;

    public TextureUpdater(TextureListInitializer textureListInitializer){
        this.currentTextures   = textureListInitializer.texturesStanding;
        this.currentTexture = textureListInitializer.texturesStanding.get(0);
        this.sprite = new Sprite(currentTexture);
        this.sprite.setSize(0.5f,0.5f);

    }

    public void updateCharacterTexture(float delta) {
        animationTime += delta;
        if (animationTime > animationInterval) {
            currentTextureIndex++;
            if (currentTextureIndex >= currentTextures.size()) {
                currentTextureIndex = 0;
            }
            this.currentTexture = currentTextures.get(currentTextureIndex);
            this.sprite.setTexture(currentTexture);
            animationTime = 0;
        }
    }

    public Sprite getSprite() {
        return sprite;
    }


}
