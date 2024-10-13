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

    public void moveLeft(Sprite sprite) {
        character.sprite.translateX(-1);
        this.character.updateTextureWalkingLeft();
        isMoving = true;
    }

    public void moveRight(Sprite sprite) {
        if(character.isTouchingObject){
            moveWithoutMotion(character);
        }else {
            character.sprite.translateX(1);
            character.updateTextureWalkingRight();
            isMoving = true;
        }
    }

    public void stopMoving(){
        if(!isMoving){
            character.updateTextureStanding();
        }
    }

    public void moveWithoutMotion(Character character) {
        character.updateTextureWalkingRight();
        isMoving = true;
    }

}
