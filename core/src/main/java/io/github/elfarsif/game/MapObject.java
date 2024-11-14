package io.github.elfarsif.game;

public class MapObject {
    Position position;

    public MapObject() {
        position = new Position(0, 0);
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public Position getPosition() {
        return position;
    }
}
