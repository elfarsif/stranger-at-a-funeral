package io.github.elfarsif.model;

import io.github.elfarsif.model.gdx.CollisionWrapper;
import io.github.elfarsif.model.map.Obstacle;
import io.github.elfarsif.model.map.Wall;

public class Collision {
    Character character;
    Wall wall;
    CollisionWrapper collisionWrapper;

    public Collision(Character character, Obstacle obstacle, CollisionWrapper collisionWrapper) {
        this.character = character;
        this.wall = wall;
        this.collisionWrapper = collisionWrapper;
    }

    public boolean isValid() {
        return this.collisionWrapper.checkCharacterOverlapsWall();
    }
}
