package com.mygdx.game;

public class MapManager {

    MapView mapView = new MapView();
    HexagonalGrid hexagonalGrid = new HexagonalGrid(Settings.gridSizeX, Settings.gridSizeY);

    public void drawGrid() {
        mapView.drawGrid(hexagonalGrid);
    }

}
