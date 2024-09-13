package io.github.elfarsif.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import io.github.elfarsif.Ressource;

import java.util.ArrayList;
import java.util.List;

public class Character {
    Texture currentTexture;
    List<Texture> textures;
    Sprite sprite;
    int currentTextureIndex = 0;
    float animationTime = 0;
    float animationInterval = 0.3f;

    public Character(){
        Ressource res = new Ressource();
        this.textures = new ArrayList<>();
        textures.add(res.getMainDownStanding1());
        textures.add(res.getMainDownStanding2());
        textures.add(res.getMainDownStanding3());
        textures.add(res.getMainDownStanding4());
        textures.add(res.getMainDownStanding5());

        this.currentTexture = textures.get(0);
        this.sprite = new Sprite(currentTexture);
        this.sprite.setSize(0.5f,0.5f);
    }

    public void updateCharacterTexture(float delta) {
        animationTime += delta;
        if (animationTime > animationInterval) {
            currentTextureIndex++;
            if (currentTextureIndex >= textures.size()) {
                currentTextureIndex = 0;
            }
            this.currentTexture = textures.get(currentTextureIndex);
            this.sprite.setTexture(currentTexture);
            animationTime = 0;
        }
    }

    public Sprite getSprite(){
        return this.sprite;
    }

    public void input(){
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.sprite.translateY(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.sprite.translateY(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.sprite.translateX(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.sprite.translateX(speed*delta);
        }
    }
}
