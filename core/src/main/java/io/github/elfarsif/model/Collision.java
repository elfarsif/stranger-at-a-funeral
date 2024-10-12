package io.github.elfarsif.model;

import com.badlogic.gdx.math.Rectangle;

public class Collision {
    public boolean isColliding(Character character, Wall wall) {
        for(Rectangle rectangle: wall.collisionRectangles){
            if(character.getSprite().getBoundingRectangle().overlaps(rectangle)){
                return true;
            }
        }
        return true;
    }
}
