package io.github.elfarsif;

import io.github.elfarsif.character.Character;

public class Grid {
    private int width;
    private int height;
    int[][] grid;

    public Grid() {
        this.width = 20;
        this.height = 15;
        grid = new int[width][height];
    }

    public int[] getSize() {
        return new int[]{width, height};
    }

    public void addCharacter(Character character) {
        grid[0][0] = 1;
    }

    public int getTile(int x, int y) {
        return grid[x][y];
    }

    public void removeCharacter(Character character) {
        grid[0][0] = 0;
    }
}
