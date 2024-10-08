package io.github.elfarsif;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;
import java.util.List;

public class MapManager {
    public TiledMap map;


    public MapManager() {
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("tilemaps/main_house_interior.tmx");
    }

    public void setMap(TiledMap map) {
        this.map = map;
    }
}
