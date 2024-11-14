package io.github.elfarsif.game.character;

import io.github.elfarsif.game.MapObject;
import io.github.elfarsif.game.Position;

public class Character {
    CHARACTER_STATE state;
    Position position;
    String currentTextureFileLocation;

    public Character() {
        state = CHARACTER_STATE.STANDING;
        position = new Position(0, 0);
        currentTextureFileLocation = "character/standing1.png";
    }

    public CHARACTER_STATE getState() {
        return state;
    }

    public Position getPosition() {
        return position;
    }

    public void moveUp() {
        position.setY(position.getY() + 1);
    }

    public void moveDown() {
        position.setY(position.getY()-1);
    }

    public void moveLeft() {
        position.setX(position.getX()-1);
    }

    public void moveRight() {
        position.setX(position.getX()+1);
    }

    public boolean hitsObject(MapObject mapObject) {
        boolean result = false;
        if (position.getX() == mapObject.getPosition().getX() && position.getY() == mapObject.getPosition().getY()) {
            result = true;
        }
        return result;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public String getCurrentTextureFileLocation() {
        return currentTextureFileLocation;
    }
}
