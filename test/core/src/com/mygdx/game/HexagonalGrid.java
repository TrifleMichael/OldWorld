package com.mygdx.game;

public class HexagonalGrid {
    GridCell[][] grid;
    int xSize;
    int ySize;

    public HexagonalGrid(int xSize, int ySize) {
        grid = new GridCell[xSize][ySize];
        this.xSize = xSize;
        this.ySize = ySize;

        for(int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                grid[i][j] = new GridCell();
                linkNeighbours(i, j);
            }
        }
    }

    // The exact method of casting hex grid to array is presented in grids-hexToArr.jpg
    private void linkNeighbours(int x, int y) {
        for (int i = x; i <= x+1; i++) {
            for (int j = y-1; j < y+1; j++) {
                if (x != i || y != j && areCoordsOnGrid(i, j)) {
                    grid[x][y].neighbours.add( grid[i][j] );
                }
            }
        }
        if (areCoordsOnGrid(x-1, y)) {
            grid[x][y].neighbours.add( grid[x-1][y] );
        }
    }

    public boolean areCoordsOnGrid(int x, int y) {
        if (0 <= x && x < xSize) {
            return 0 <= y && y < ySize;
        }
        return false;
    }
}
