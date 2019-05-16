package com.bezos.witsiemon.model;

public class TileMap {
	private int width, height;
	private Tile[][] map;

	public TileMap(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		
		for (Tile[] i: map) {
			for (Tile j: i) {
				j = new Tile(TERRAIN.GRASS_1);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		return map[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
