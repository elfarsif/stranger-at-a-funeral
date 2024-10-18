package io.github.elfarsif;

public class Wall {
    int x,y;

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }
}
