package io.github.elfarsif;

import io.github.elfarsif.character.Character;

public class Map {
    private static final int TILE_SIZE = 16;
    private int width = 20;
    private int height =15;
    Tile[][] grid;

    public Map() {
        grid = new Tile[width][height];
        initializeMapWithTiles();
    }

    private void initializeMapWithTiles(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new Tile();
            }
        }
    }

    public int[] getSize() {
        return new int[]{width, height};
    }

    public Tile getTile(int x, int y) {
        return grid[x][y];
    }

    public boolean isValidPosition(Character character) {
        boolean isValid = false;
        if(character.getPosition()[0]*TILE_SIZE>=0 &&
            character.getPosition()[0]*TILE_SIZE<=width*TILE_SIZE &&
            character.getPosition()[1]*TILE_SIZE>=0 &&
            character.getPosition()[1]*TILE_SIZE<=height*TILE_SIZE
        ){
            isValid = true;
        }
        return isValid;
    }

    public boolean isValidPosition(int x, int y) {
        boolean isValid = false;
        if(x*TILE_SIZE>=0 &&
            x*TILE_SIZE<=width*TILE_SIZE &&
            y*TILE_SIZE>=0 &&
            y*TILE_SIZE<=height*TILE_SIZE
        ){
            isValid = true;
        }
        return isValid;
    }
}
