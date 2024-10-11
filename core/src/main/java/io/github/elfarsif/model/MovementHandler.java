package io.github.elfarsif.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovementHandler {
    Character character;
    public boolean isMoving = false;

    public MovementHandler(Character character) {
        this.character = character;
    }

    void moveUp(Sprite sprite) {
        character.sprite.translateY(1);
        character.updateTextureWalkingUp();
        isMoving = true;
    }

    void moveDown(Sprite sprite) {
        character.sprite.translateY(-1);
        this.character.updateTextureWalkingDown();
        isMoving = true;
    }

    void moveLeft(Sprite sprite) {
        character.sprite.translateX(-1);
        this.character.updateTextureWalkingLeft();
        isMoving = true;
    }

    void moveRight(Sprite sprite) {
        character.sprite.translateX(1);
        character.updateTextureWalkingRight();
        isMoving = true;
    }

    public void stopMoving(){
        if(!isMoving){
            character.updateTextureStanding();
        }
    }


}
