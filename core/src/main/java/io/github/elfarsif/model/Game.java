package io.github.elfarsif.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game {
    Character character;
    Map map;
    MovementHandler movementHandler;

    public Game(Map map, Character character, MovementHandler movementHandler) {
        this.map = map;
        this.character = character;
        this.movementHandler = movementHandler;
    }

    public void move(Character character, String direction) {
        if(direction.equals("up")){
            this.movementHandler.moveUp(character.sprite);
        }
        if(direction.equals("down")){
            this.movementHandler.moveDown(character.sprite);
        }
        if(direction.equals("left")){
            this.movementHandler.moveLeft(character.sprite);
        }
        if(direction.equals("right")){
            this.movementHandler.moveRight(character.sprite);
        }
    }

}
