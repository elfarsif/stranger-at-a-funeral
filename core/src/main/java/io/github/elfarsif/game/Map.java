package io.github.elfarsif.game;

public class Map {
    Tile[][] grid;

    public Map(){
        grid = new Tile[20][30];
        initializeMapWithTiles();
    }

    private void initializeMapWithTiles() {
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                grid[i][j]=new Tile();
            }
        }
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void addTextureToMapTile(int x, int y, String filename) {
        grid[y][x].setTextureFileLocation(filename);
    }
}
