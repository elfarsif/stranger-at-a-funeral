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
    List<Texture> currentTextures;
    List<Texture> texturesStanding;
    List<Texture> texturesWalking;
    Sprite sprite;
    int currentTextureIndex = 0;
    float animationTime = 0;
    float animationInterval = 0.3f;

    public Character(){
        Ressource res = new Ressource();
        this.texturesStanding = new ArrayList<>();
        texturesStanding.add(res.getMainDownStanding1());
        texturesStanding.add(res.getMainDownStanding2());
        texturesStanding.add(res.getMainDownStanding3());
        texturesStanding.add(res.getMainDownStanding4());
        texturesStanding.add(res.getMainDownStanding5());

        this.texturesWalking = new ArrayList<>();
        texturesWalking.add(res.getMainWalkingDown1());
        texturesWalking.add(res.getMainWalkingDown2());
        texturesWalking.add(res.getMainWalkingDown3());
        texturesWalking.add(res.getMainWalkingDown4());
        texturesWalking.add(res.getMainWalkingDown5());

        this.currentTextures   = texturesStanding;

        this.currentTexture = texturesStanding.get(0);
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



    public Sprite getSprite(){
        return this.sprite;
    }

    public void input(){
        float speed = 1f;
        float delta = Gdx.graphics.getDeltaTime();
        boolean keyPressed = false;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.sprite.translateY(speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.currentTextures = texturesWalking;
            this.sprite.translateY(-speed*delta);
            keyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.sprite.translateX(-speed*delta);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.sprite.translateX(speed*delta);
        }
        if(!keyPressed){
            this.currentTextures = texturesStanding;
        }
    }
}
