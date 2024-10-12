package io.github.elfarsif.model;

import com.badlogic.gdx.math.Rectangle;

public class Collision {
    Character character;
    Wall wall;
    CollisionWrapperGdx collisionWrapperGdx;

    public Collision(Character character, Wall wall, CollisionWrapperGdx collisionWrapperGdx) {
        this.character = character;
        this.wall = wall;
        this.collisionWrapperGdx = collisionWrapperGdx;
    }

    public boolean isValid() {
        return this.collisionWrapperGdx.checkCharacterOverlapsWall();
    }
}
