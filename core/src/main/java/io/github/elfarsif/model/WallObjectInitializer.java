package io.github.elfarsif.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.List;


public class WallObjectInitializer {
    public List<Rectangle> initialize() {
        Map map = new HouseMap();
        TmxMapLoader loader = new TmxMapLoader();
        TiledMap tiledMap =loader.load(map.getAssetFileName());
        List<Rectangle> collisionRectangles = new ArrayList<>();

        for (MapObject object:tiledMap.getLayers().get("walls").getObjects()) {
            if (object instanceof RectangleMapObject) {
                RectangleMapObject rectangleObject = (RectangleMapObject) object;
                Rectangle rectangle = rectangleObject.getRectangle();
                collisionRectangles.add(rectangle);
            }
        }

        return collisionRectangles;
    }
}
