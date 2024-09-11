package io.github.elfarsif.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Character {
    private String state;
    private int x;
    private int positionY;
    private int width = 1;
    private int height = 1;

    public Character() {
        this.state = "player.png";
    }

    public String getState() {
        return this.state;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.positionY = y;
    }

    public void moveDown() {
        this.positionY--;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getPositionX() {
        return 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
