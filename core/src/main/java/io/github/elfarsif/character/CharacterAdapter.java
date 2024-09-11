package io.github.elfarsif.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CharacterAdapter {
    private Texture texture;
    private Sprite sprite;
    private Character character;

    public CharacterAdapter(Character character) {
        this.character = character;
        this.texture = new Texture(character.getState());
        this.sprite = new Sprite(this.texture);
        this.sprite.setSize(this.character.getWidth(),this.character.getHeight());
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public Character getCharacter() {
        return this.character;
    }
}
