package io.github.elfarsif.model.gdx;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import io.github.elfarsif.model.map.Map;

import java.util.ArrayList;
import java.util.List;


public class MapObjectExtractor {
    Map map;

    public MapObjectExtractor(Map map) {
        this.map = map;
    }

    public List<Rectangle> extract() {
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
