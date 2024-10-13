package io.github.elfarsif.model;

import com.badlogic.gdx.math.Rectangle;

public class CollisionWrapperGdx {
    Character character;
    Wall wall;

    public CollisionWrapperGdx(Character character, Wall wall) {
        this.character = character;
        this.wall = wall;
    }

    public boolean checkCharacterOverlapsWall() {

        for(Rectangle rectangle: wall.collisionRectangles){
            if(character.getSprite().getBoundingRectangle().overlaps(rectangle)){
                return true;
            }
        }
        return false;
    }
}
