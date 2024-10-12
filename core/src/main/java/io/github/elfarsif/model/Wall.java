package io.github.elfarsif.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    Map map;
    WallObjectInitializer wallObjectInitializer;
    List<Rectangle> collisionRectangles;


    public Wall(Map map, WallObjectInitializer wallObjectInitializer) {
        this.map = map;
        this.wallObjectInitializer = wallObjectInitializer;
    }

    public void initilizeCollisionObjects() {
        collisionRectangles = wallObjectInitializer.initialize();
    }

    public List<Rectangle> getCollisionRectangles() {
        return collisionRectangles;
    }

}
