package io.github.elfarsif.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game {
    Character character;
    Map map;
    public boolean isMoving = false;

    public Game(Map map, Character character) {
        this.map = map;
        this.character = character;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void moveUp(Sprite sprite) {
        sprite.translateY(1);
        character.updateTextureWalkingUp();
        isMoving = true;
    }

    public Map getMap() {
        return this.map;
    }

    public void moveDown(Sprite sprite) {
        sprite.translateY(-1);
        this.character.updateTextureWalkingDown();
        isMoving = true;
    }

    public void moveLeft(Sprite sprite) {
        sprite.translateX(-1);
        this.character.updateTextureWalkingLeft();
        isMoving = true;
    }

    public void moveRight(Sprite sprite) {
        sprite.translateX(1);
        character.updateTextureWalkingRight();
        isMoving = true;
    }

    public void stopMoving(){
        if(!isMoving){
            character.updateTextureStanding();
        }
    }

    public void setCharacterInHouse() {
        character.setX((float) 7.5*16);
        character.setY((float) 5*16);
    }

    public void move(Character character, String direction) {
        if(direction.equals("up")){
            this.moveUp(character.sprite);
        }
    }
}
