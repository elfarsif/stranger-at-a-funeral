package io.github.elfarsif.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import io.github.elfarsif.MapManager;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    TextureUpdater textureUpdater;
    TextureListInitializer textureListInitializer;
    MapManager mapManager;
    boolean keyPressed;
    float speed = 68f;
    //collision
    private List<Rectangle> collisionRectangles;
    private TiledMap map;
    private TiledMap houseMap;

    public InputHandler(TextureUpdater textureUpdater, TextureListInitializer textureListInitializer, MapManager mapManager){
        this.textureUpdater = textureUpdater;
        this.textureListInitializer = textureListInitializer;
        this.mapManager = mapManager;


        TmxMapLoader loader = new TmxMapLoader();

        houseMap = loader.load("tilemaps/main_house_interior.tmx");

        map = loader.load("tilemaps/ship.tmx");

        collisionRectangles = new ArrayList<Rectangle>();

        for (MapObject object:map.getLayers().get("walls").getObjects()) {
            if (object instanceof RectangleMapObject) {
                RectangleMapObject rectangleObject = (RectangleMapObject) object;
                Rectangle rectangle = rectangleObject.getRectangle();
                collisionRectangles.add(rectangle);
            }
        }
    }


    public void execute(){
        float delta = Gdx.graphics.getDeltaTime();
        keyPressed = false;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (!isColliding(this.textureUpdater.sprite)){
                moveUp(speed, delta);
                keyPressed = true;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (!isColliding(this.textureUpdater.sprite)){
                this.mapManager.setMap(map);
                System.out.println("map changed");
            }
            moveDown(speed, delta);
            keyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft(speed, delta);
            keyPressed = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (!isColliding(this.textureUpdater.sprite)){
                moveRight(speed, delta);
                keyPressed = true;
            }
        }
        if(!keyPressed){
            this.textureUpdater.currentTextures = this.textureListInitializer.texturesStanding;
        }
    }

    public void moveUp(float speed, float delta) {
        this.textureUpdater.currentTextures= this.textureListInitializer.texturesWalkingUp;
        this.textureUpdater.sprite.translateY(speed * delta);
        keyPressed = true;
    }

    private void moveDown(float speed, float delta) {
        this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalking;
        this.textureUpdater.sprite.translateY(-speed * delta);
        keyPressed = true;
    }

    private void moveRight(float speed, float delta) {
        this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalkingRight;
        this.textureUpdater.sprite.translateX(speed * delta);
        keyPressed = true;
    }

    private void moveLeft(float speed, float delta) {
        this.textureUpdater.currentTextures = this.textureListInitializer.texturesWalkingLeft;
        this.textureUpdater.sprite.translateX(-speed * delta);
        keyPressed = true;
    }

    private boolean isColliding(Sprite sprite){
        for(Rectangle rectangle: collisionRectangles){
            if(sprite.getBoundingRectangle().overlaps(rectangle)){
                return true;
            }
        }
        return false;
    }


}
