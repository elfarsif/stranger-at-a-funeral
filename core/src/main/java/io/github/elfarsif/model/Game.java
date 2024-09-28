package io.github.elfarsif.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game {
    Player player;
    Map map;

    public void start() {
        this.player = new Player();
        this.map = new Map();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void moveUp(Sprite sprite) {
        sprite.translateY(1);
    }

    public Map getMap() {
        return this.map;
    }

    public void moveDown(Sprite sprite) {
        sprite.translateY(-1);
    }

    public void moveLeft(Sprite sprite) {
        sprite.translateX(-1);
    }
}
