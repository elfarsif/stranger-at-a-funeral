package io.github.elfarsif.model.gdx;

import com.badlogic.gdx.math.Rectangle;
import io.github.elfarsif.model.Character;
import io.github.elfarsif.model.map.Obstacle;

public class CollisionWrapper {
    Character character;
    Obstacle obstacle;

    public CollisionWrapper(Character character, Obstacle obstacle) {
        this.character = character;
        this.obstacle = obstacle;
    }

    public boolean checkCharacterOverlapsWall() {
        for(Rectangle rectangle: obstacle.getCollisionRectangles()){
            if(character.getSprite().getBoundingRectangle().overlaps(rectangle)){
                return true;
            }
        }
        return false;
    }
}
