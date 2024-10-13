package io.github.elfarsif.model;

import com.badlogic.gdx.math.Rectangle;
import io.github.elfarsif.model.gdx.MapObjectExtractor;
import io.github.elfarsif.model.map.Map;

import java.util.List;

public class Wall implements Obstacle{
    Map map;
    MapObjectExtractor mapObjectExtractor;
    List<Rectangle> collisionRectangles;


    public Wall(Map map, MapObjectExtractor mapObjectExtractor) {
        this.map = map;
        this.mapObjectExtractor = mapObjectExtractor;
    }

    @Override
    public void initializeCollisionObjects() {
        collisionRectangles = mapObjectExtractor.extract();
    }

    @Override
    public List<Rectangle> getCollisionRectangles() {
        return collisionRectangles;
    }

}
