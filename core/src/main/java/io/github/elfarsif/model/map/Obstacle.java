package io.github.elfarsif.model.map;

import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public interface Obstacle {
    public void initializeCollisionObjects();
    public List<Rectangle> getCollisionRectangles();
}
